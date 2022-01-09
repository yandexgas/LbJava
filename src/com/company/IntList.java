package com.company;

/*
 * По хорошему удобнее было бы обычный лист реализовать с дженериками, но раз сказали делать без них, то ладно)
 * Во втором задании сказали сделать функцию для слияния списков, желательно на своем списке, заменив object на int.
 * ну я просто чтобы не портить изначальный обычный список, завернул его в отдельный класс с такми же методами, только
 * принимающими int.
 * есть два метода, один статический - 1 в 1 с условием задания просто принимает два списка и возвращает их объединение
 * этот метод просто ссылется на обычный метод класса, который выполняет объединение экземпляра класса и параметра метода.*/
public class IntList {
    private List lst;

    IntList() {
        lst = new List();
    }

    IntList(IntList l) {
        lst = new List(l.lst);
    }

    int size() {
        return lst.size();
    }

    public void add(int val) {
        lst.add(val);
    }

    public void add(int val, int pos) {
        lst.add(val, pos);
    }

    public int get(int pos) {

        return (int) lst.get(pos);
    }

    public int remove(int pos) {
        return (int) lst.remove(pos);
    }

    public int set(int val, int pos) {

        return (int) lst.set(val, pos);
    }

    public boolean contains(int val) {

        return lst.contains(val);
    }

    public int indexOf(int val) {
        return lst.indexOf(val);
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public void mergeInto(IntList l2) {
        int ptr1 = 0, ptr2 = 0;
        while (ptr2 < l2.size()) {
            if (ptr1 < size() && l2.get(ptr2) <= get(ptr1)) {
                add(l2.get(ptr2), ptr1);
                ++ptr2;
            } else if (ptr1 >= size()) {
                add(l2.get(ptr2));
                ++ptr2;
            }
            ++ptr1;
        }
    }

    public static IntList Merge(IntList l1, IntList l2) {
        IntList l = new IntList(l1);
        l.mergeInto(l2);
        return l;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<lst.size();i++){
            res.append(lst.get(i));
            res.append(' ');
        }
        return res.toString();
    }
}
