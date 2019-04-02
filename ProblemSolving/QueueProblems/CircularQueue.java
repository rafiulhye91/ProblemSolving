class CircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    int mQueue[];
    int mSize;
    int mFront;
    int mRear;
    int mCount;
    public MyCircularQueue(int k) {
        mQueue = new int[k];
        mSize = k;
        mFront = 0;
        mRear = -1;
        mCount = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        mRear = (mRear+1)%mSize;
        mQueue[mRear] = value;
        mCount++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        mFront++;
        mCount--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return mQueue[mFront];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return mQueue[mRear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (mCount==0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (mCount==mSize);
    }
}
