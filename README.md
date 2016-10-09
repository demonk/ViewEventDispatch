对于View的事件派发，包含几个主要的方法
dispatcherTouchEvent
onTouch
onTouchEvent
优先级从上到下,ViewGroup在dispatcherTouchEvent与onTouch之间加了onInterceptTouchEvent.

## View
一般的view在接到到touch事件时，会触发到dispatcherTouchEvent，视dispatcherTouchEvent的返回值不同而定，会导致touch事件的走向也不定
- return false

  当返回false时，表示这个事件当前的view不处理，需要交给它所在的下层view去处理，当前view的onTouch,onTouchEvent都不会去触发。
  这里的下层指的是屏幕上view元素的叠加情况，而并非指嵌套，如
  
  ```xml
    <android.view.ViewGroup>
      <Button/>
    <android.view.ViewGroup>
    <Button/>
  ```
  
  则第二个Button与ViewGroup并列，如果ViewGroup与Button发生重叠，则一般情况下Button会在ViewGroup的上方。
  
- return true

  当返回true时，表示事件由当前view处理了，不需要再向上传递这个触摸事件
  
- return super.dispatchTouchEvent

  如果view没有对dispatchTouchEvent进行特别的拦截操作，则最终会调用到View的dispatchTouchEvent
  其内实现是
  ```java
      public boolean dispatchTouchEvent(MotionEvent event) {  
        if(mOnTouchListener != null && 
          (mViewFlags & ENABLED_MASK) == ENABLED &&
          mOnTouchListener.onTouch(this, event)) {  
            return true;  
        }  
          return onTouchEvent(event); 
      } 
  ```
      
  如果去拦截view的一些点击操作，则可以在这里进行dispatch，只要不调用到super.dispatchTouchEvent,就不会调用到onTouch,onTouchEvent等处理方法，但默认的dispatchTouchEvent会进行以下的几个处理
    - 检查是否有设置onTouchListener
    - 检查view是否enabled
    - 检查onTouchListener.onTouch返回值
      - 为true,则整个dispatchTouchEvent返回true，表示消息已经处理，不再向上传递
      - 为false,则执行onTouchEvent
        - 为true，表示事件已经处理，不再向上传递
        - 为false,表示不处理事件，需要向上传递

总的来说，dispatchTouchEvent是一个入口，其可以实现拦截touch操作，进行默认的事件分发，并返回true/false表示消息是否已处理/未处理。

默认的onTouchEvent则是用来判断当次事件具有什么操作的，如是否点击等。

![img_view](/ViewEvent_View.png)

## ViewGroup
  ViewGroup也是View，只不过是可以包含子View的View。
  当ViewGroup发生touch事件时，也是先由dispatchTouchEvent先行触发，其返回值具有与view相同的含义
  - return false
    不处理，向上传
  - return true
    表示已处理，不向上传
  - return super.dispatchTouchEvent
    默认的dispatchTouchEvent会触发onInterceptTouchEvent，可以在这里进行一些拦截的操作,其返回值也具备意义 
      - return false:表示事件未处理，viewgroup的onTouch事件不会触发，需要将事件传递给子view,按子view的层叠情况从上到下传递,直到有view处理这个事件
      - return true:表示事件已处理，viewgroup的onTouch，onTouchEvent都会被触发，结束touch消息传递
      onInterceptTouchEvent的结果值会导致dispatchTouchEvent选择不同的逻辑，如应该传递给子view还是触发viewGroup的onTouch,onTouchEvent
      默认的onInterceptTouchEvent会返回false
  
![img_viewgroup](/ViewEvent_ViewGroup.png)  

### 参考
[源码分析1](http://blog.csdn.net/guolin_blog/article/details/9097463)
[源码分析2](http://blog.csdn.net/sinyu890807/article/details/9153747)

