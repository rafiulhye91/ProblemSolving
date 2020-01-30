/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
*/

class Solution {
    ListString mStackS;
    ListString mStackT;
    int mTop;
    int mSize;
    int mCount;
    public boolean backspaceCompare(String S, String T) {
        mStackS = new ArrayListString();
        mStackT = new ArrayListString();
        int size =S.length();
        init(size);
        performBackSpaceCompare(S, mStackS, size);
        size =T.length();
        init(size);
        performBackSpaceCompare(T, mStackT, size);
        return mStackS.equals(mStackT);
    }
    
    private void init(int size){
        mTop =-1;
        mSize= size;
        mCount=0;
    }
    
    private void performBackSpaceCompare(String str, ListString list, int size){
        for(int i=0; isize;i++){
            char c = str.charAt(i); 
            if(c!='#'){
                push(Character.toString(c), list);
            }else{
                pop(list);
            }
        }
    }
    
    private boolean isEmpty(){
        return mCount==0;
    }
    
    private boolean isFull(){
        return mCount==mSize;
    }
    
    private void push(String c, ListString list){
        if(isFull()){
            return;
        }
        mTop++;
        list.add(mTop,c);
        mCount++;
    }
    
    private void pop(ListString list){
        if(isEmpty()){
            return;
        }
        list.remove(mTop);
        mTop--;
        mCount--;
    }
}