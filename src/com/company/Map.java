package com.company;

public class Map {
    enum status {free,busy,deleted}
    private int size;
    private  final int inc;
    private int count=0;
    private boolean SuccessSearchFlag;
    private hTabbleObject[] HashTable;
    public Map(int defSize){
        if((defSize&1)==1){
        size=defSize;
        inc = defSize+1;
        }
        else{
            size=defSize+1;
            inc=defSize;
        }
        HashTable=new hTabbleObject[size];
        for(int i=0;i<size;i++)
            HashTable[i]=new hTabbleObject();
    }
    public Map(){
        size=41;
        inc = 40;
        HashTable=new hTabbleObject[size];
    }
    private class hTabbleObject{
        public Pair node=new Pair();
        public status busy=status.free;
        hTabbleObject(){};
    }

    private int find(Object key){
        int index=(key.hashCode())%size;
        int result = -1;
        SuccessSearchFlag=false;
        int i =0;
        for(;i<size;++i){
            switch (HashTable[index].busy) {
                case free:{
                    result=result==-1?index:result;
                }
                    break;
                case busy:{
                    if(HashTable[index].node.first.equals(key)){
                    SuccessSearchFlag=true;
                    result = index;
                    }
                    else {
                        index=(index+2)%size;
                        continue;
                    }
                }
                    break;
                case deleted:{
                    result=result==-1?index:result;
                    index=(index+2)%size;
                    continue;
                }
            }
            break;
        }
        return  result;
    }

    public void put(Object key,Object value){
        int index=find(key);
        if(index==-1) {
            incSize();
            put(key,value);
        }
        else{
            HashTable[index].node.second=value;
            if(!SuccessSearchFlag){
                ++count;
                HashTable[index].node.first=key;
                HashTable[index].busy=status.busy;
            }
        }
    }
    public void put(Pair p){
        put(p.first,p.second);
    }
    public Object get(Object key){
        int index=find(key);
        Object result=null;
        if(SuccessSearchFlag){
            result=HashTable[index].node.second;
        }
        return result;
    }
    public  Object get(Object key, Object byDefault) {
        Object result = null;
        result = get(key);
        if (result == null) {
            put(key, byDefault);
            result = byDefault;
        }
        return  result;
    }
    public Object remove(Object key){
        int index=find(key);
        Object result=null;
        if(SuccessSearchFlag){
            --count;
            HashTable[index].busy=status.deleted;
            result=HashTable[index].node.second;
        }
        return result;
    }
    public boolean keyContains(Object key){
        find(key);
        return SuccessSearchFlag;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public List getKeys(){
        List result = new List();
        for(int i=0;i<size;++i){
            if(HashTable[i].busy==status.busy)
                result.add(HashTable[i].node.first);
        }
        return  result;
    }
    public List getValues(){
        List result = new List();
        for(int i=0;i<size;++i){
            if(HashTable[i].busy==status.busy)
                result.add(HashTable[i].node.second);
        }
        return  result;
    }
    public List getEntries(){
        List result = new List();
        for(int i=0;i<size;++i){
            if(HashTable[i].busy==status.busy)
                result.add(HashTable[i].node);
        }
        return  result;
    }

    private void incSize(){
        hTabbleObject [] newTab=new hTabbleObject[size+inc];
        List nodes= getEntries();
        HashTable=newTab;
        count=0;
        size=size+inc;
        for(int i=0;i<size;i++)
            HashTable[i]=new hTabbleObject();
        for(int i=0;i<nodes.size();i++){
            put((Pair) nodes.get(i));
        }
    }
}
