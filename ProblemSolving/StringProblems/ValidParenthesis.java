/*
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
/*

import java.util.*;

class Solution {
    char mStack[];
    int mTop;
    int mCount;
    int mSize;
    char mOpenBraces[];
    char mCloseBraces[];
    
    public boolean isValid(String s) {
        int size = s.length();
        if(size==0){
            return true;
        }
        if(size==1){
            return false;
        }
        initMembers(size);
        
        for(int i=0; i<size; i++){
            
            if(contains(s.charAt(i), mOpenBraces)){
                push(s.charAt(i));
            }
            if(contains(s.charAt(i), mCloseBraces)){
                if(isDesiredBrace(s.charAt(i))){
                    pop();
                }
                else{
                    return false;
                }
            }
        }
        if(mCount==0){
            return true;
        }
        return false;
    }
    
    private void initMembers(int size){
        mStack = new char[size];
        mSize = size;
        mCount =0;
        mTop = -1;
        mOpenBraces = new char[3];
        mCloseBraces = new char[3];
        initBraces();
    }
    
    private void initBraces(){
        mOpenBraces[0]='(';
        mOpenBraces[1]='{';
        mOpenBraces[2]='[';
        
        mCloseBraces[0]=')';
        mCloseBraces[1]='}';
        mCloseBraces[2]=']';
    }
    
    private boolean contains(char c, char[] charArray){
        for(int i=0; i<3; i++){
            if(c==charArray[i]){
                return true;
            }
        }
        return false;
    }
    
    private boolean isDesiredBrace(char c){
        char topChar = peek();
        if(c==')' && topChar == '('){
            return true;
        }
        if(c=='}' && topChar == '{'){
            return true;
        }
        if(c==']' && topChar == '['){
            return true;
        }
        return false;
    }
    
    private boolean isFull(){
        return (mCount==mSize);
    }
    
    private boolean isEmpty(){
        return (mCount==0);
    }
    
    private char peek(){
        if(isEmpty()){
            return 0;
        }
        return mStack[mTop];
    }
    
    private boolean push(char c){
        
        if(isFull()){
            return false;
        }
        mTop++;
        
        mStack[mTop] = c;
        mCount++;
        return true;
    }
    
    private boolean pop(){
        if(isEmpty()){
            return false;
        }
        mTop--;
        mCount--;
        return true;
    }
}