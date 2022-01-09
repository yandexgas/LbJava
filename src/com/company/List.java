package com.company;

public class List {
    private ListOb top = null;
    private ListOb end = null;
    private int sz = 0;

    private class ListOb {
        ListOb(Object val) {
            this.val = val;
            next = null;
        }

        Object val;
        ListOb next;
    }

    public List() {
    }

    public List(List l) {
        for (int i = 0; i < l.size(); ++i) {
            add(l.get(i));
        }
    }

    int size() {
        return sz;
    }

    public void add(Object val) {
        if (top == null) {
            top = new ListOb(val);
            end = top;
        } else {
            end.next = new ListOb(val);
            end = end.next;
        }
        ++sz;
    }

    public void add(Object val, int pos) {
        if (top == null) {
            add(val);
            return;
        }
        ListOb tmp = top;
        ListOb newOb = new ListOb(val);

        if (pos <= 0) {
            newOb.next = top;
            top = newOb;
        } else {
            for (int i = 0; i < pos - 1 && i < sz - 1; ++i) {
                tmp = tmp.next;
            }

            newOb.next = tmp.next;
            tmp.next = newOb;
        }
        if (pos >= sz) {
            end = end.next;
        }
        sz++;
    }

    public Object get(int pos) {
        Object result = null;
        ListOb tmp = top;
        for (int i = 0; i < pos && i < sz; ++i) {
            tmp = tmp.next;
        }
        if (pos < sz && pos >= 0) {
            result = tmp.val;
        }
        return result;
    }

    public Object remove(int pos) {
        Object result = null;
        ListOb tmp = top;
        if (top == null || pos < 0 || pos >= sz)
            return result;
        if (pos == 0) {
            result = top.val;
            top = top.next;
        } else {

            if (pos < sz) {
                for (int i = 0; i < pos - 1; ++i) {
                    tmp = tmp.next;
                }
                result = tmp.next.val;
                tmp.next = tmp.next.next;
                if (pos == sz - 1)
                    end = tmp;
            }
        }
        if (--sz == 0) {
            top = end = null;
        }
        return result;
    }

    public Object set(Object val, int pos) {
        Object res = null;
        ListOb tmp = top;
        if (pos < sz && pos >= 0) {
            for (int i = 0; i < pos; i++) {
                tmp = tmp.next;
            }
            res = tmp.val;
            tmp.val = val;
        }
        return res;
    }

    public boolean contains(Object val) {

        return indexOf(val) > -1;
    }

    public int indexOf(Object val) {
        ListOb tmp = top;
        for (int i = 0; i < sz; i++) {
            if (tmp.val.equals((val))) {
                return i;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    public boolean isEmpty() {
        return sz == 0;
    }
}

