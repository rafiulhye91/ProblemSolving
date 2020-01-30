/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    List<Integer> mStack;
    List<Integer> minStack;
    int mTop;
    int minTop;
    int mCount;
    int mMin;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new ArrayList<Integer>(); 
        minStack = new ArrayList<Integer>();
        mTop = -1;
        minTop = -1;
        mCount = 0;
    }
    
    public void push(int x) {
        
        if(mTop==-1 || minPeek()>=x){
            
            pushMinStack(x);
        }
        mTop++;
        mStack.add(mTop, x);
        mCount++;
    }
    
    public void pop() {
        if(isEmpty()){
            return;
        }
        if(mStack.get(mTop) == minPeek()){
            popMinStack();
        }
        mStack.remove(mTop);
        mTop--;
        mCount--;
    }
    
    public int top() {
        return mStack.get(mTop).intValue();
    }
    
    public int getMin() {
        return minStack.get(minTop).intValue();
    }
    
    private boolean isEmpty(){
        return (mCount==0);
    }
    
    private int minPeek(){
        return minStack.get(minTop).intValue();
    }
    
    private void pushMinStack(int x){
        
        minTop++;
        minStack.add(minTop, x);
    }
    
    public void popMinStack() {
        if(minTop<0){
            return;
        }
       
        minStack.remove(minTop);
        minTop--;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */