/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_1;

/**
 *
 * @author Admin
 */
public class List {

    Car head, tail;
    int size;

    public List() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void display() { 
        Car cur = head;
        while (cur != null) {
            if (cur.next == null) {
                System.out.println(cur.toString());
            } else {
                System.out.print(cur.toString() + ",");
            }
            cur = cur.next;
        }
        System.out.println("");
    }

    void addLast(String a, double b) { 
        Car ca = new Car(a, b);
        if (a.charAt(0) != 'B' && b <= 100) {
            if (isEmpty()) {
                head = tail = ca;
            } else {
                tail.next = ca;
                tail = ca;
            }
            size++;
        }
    }

    void addFirst(String name, double price) {
        Car ca = new Car(name, price);
        if (isEmpty()) {
            head = tail = ca;
        } else {
            ca.next = head;
            head = ca;
        }
        size++;
    }

    int findSmallerIndex(double value) {
        Car cur = head;
        int count = 0, temp = 0;
        while (count != 1 && cur != null) {
            if (cur.Price < value) {
                count++;
            }
            temp++;
            cur = cur.next;
        }
        if (count == 0) {
            return count - 1;
        } else {
            return temp;
        }
    }

    void addSmallerIndex(String name, double price, double value) {
        int ind = findSmallerIndex(value);
        if (ind < 0) {
            System.out.println("No element had price smaller than value");
        } else {
            if (ind == 0) {
                addFirst(name, price);
                return;
            }
            if (ind == size) {
                addLast(name, value);
                return;
            }
            int count = 0;
            Car cur = head;
            while (cur != null && count != ind - 1) {
                count++;
                cur = cur.next;
            }
            if (cur == null) {
                return;
            } else {
                Car ca = new Car(name, price);
                ca.next = cur.next;
                cur.next = ca;
                size++;
            }
        }
    }

    void addIndext(String name, double value, int indext) {
        if (indext == 0) {
            addFirst(name, value);
            return;
        }
        if (indext == size) {
            addLast(name, value);
            return;
        }
        int count = 0;
        Car cur = head;
        while (count != indext - 1) {
            count++;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        } else {
            Car node = new Car(name, value);
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    void deleteIndex(int ind) {
        int count = 0;
        Car cur = head;
        if (ind < 0 || ind > size) {
            return;
        }
        if (ind == 0) {
            head = head.next;
            return;
        }
        while (count != ind - 1) {
            count++;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    void moveMax() {
        Car cur = head.next;
        int ind = 1, indMax = 0;
        Car temp = head;
        while (cur != null) {
            if (cur.Price > temp.Price) {
                indMax = ind;
                temp = cur;
            }
            ++ind;
            cur = cur.next;
        }
        deleteIndex(indMax);
        addLast(temp.Name, temp.Price);
    }

    void moveMin() {
        Car cur = head.next;
        int ind = 1, indMin = 0;
        Car temp = head;
        while (cur != null) {
            if (cur.Price < temp.Price) {
                indMin = ind;
                temp = cur;
            }
            cur = cur.next;
            ind++;
        }
        deleteIndex(indMin);
        addFirst(temp.Name, temp.Price);
    }

    boolean checkPrime(double price) {
        int n = (int) price;
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int countPrime() {
        int n = 0;
        Car cur = head;
        while (cur != null) {
            if (checkPrime(cur.Price)) {
                n++;
            }
            cur = cur.next;
        }
        if (n < 3) {
            System.out.println("Not enough Prime element to sort!");
            return -1;
        }
        return n;
    }

    void sortThreeFirstPrimePrice() {
        Car cur = head;
        int i = 0;
        int ind2 = 0, ind1 = 0, n = countPrime();
        int ind = 0;
        int ind3 = 0;
        Car temp1 = new Car();
        Car temp2 = new Car();
        Car temp3 = new Car();
        if (n < 0) {
            return;
        }
        while (i <= 3) {
            if (checkPrime(cur.Price) == true) {
                i++;
                if (i == 1) {
                    temp1 = cur;
                    ind1 = ind;
                }
                if (i == 2) {
                    temp2 = cur;
                    ind2 = ind;
                }
                if (i == 3) {
                    temp3 = cur;
                    ind3 = ind;
                }
            }
            ind++;
            cur = cur.next;
        }
        if (temp1.Price > temp2.Price) {
            if (temp1.Price > temp3.Price) {
                deleteIndex(ind1);
                addIndext(temp3.Name, temp3.Price, ind1);
                deleteIndex(ind3);
                addIndext(temp1.Name, temp1.Price, ind3);
                if (temp3.Price > temp2.Price) {
                    deleteIndex(ind1);
                    addIndext(temp2.Name, temp2.Price, ind1);
                    deleteIndex(ind2);
                    addIndext(temp3.Name, temp3.Price, ind2);
                }
            } else {
                deleteIndex(ind1);
                addIndext(temp2.Name, temp2.Price, ind1);
                deleteIndex(ind2);
                addIndext(temp1.Name, temp1.Price, ind2);
            }
        } else if (temp2.Price > temp3.Price) {
            deleteIndex(ind2);
            addIndext(temp3.Name, temp3.Price, ind2);
            deleteIndex(ind3);
            addIndext(temp2.Name, temp2.Price, ind3);
        }
    }

    void sortThreeLastPrimePrice() {
        Car cur = head;
        int ind2 = 0, ind1 = 0, n = countPrime();
        int ind = 0;
        int ind3 = 0;
        Car temp1 = new Car();
        Car temp2 = new Car();
        Car temp3 = new Car();
        if (n < 0) {
            return;
        }
        while (n != 0) {
            if (checkPrime(cur.Price) == true) {

                if (n == 3) {
                    temp1 = cur;
                    ind1 = ind;
                }
                if (n == 2) {
                    temp2 = cur;
                    ind2 = ind;
                }
                if (n == 1) {
                    temp3 = cur;
                    ind3 = ind;
                }
                n--;
            }
            ind++;
            cur = cur.next;
        }
        if (temp1.Price > temp2.Price) {
            if (temp1.Price > temp3.Price) {
                deleteIndex(ind1);
                addIndext(temp3.Name, temp3.Price, ind1);
                deleteIndex(ind3);
                addIndext(temp1.Name, temp1.Price, ind3);
                if (temp3.Price > temp2.Price) {
                    deleteIndex(ind1);
                    addIndext(temp2.Name, temp2.Price, ind1);
                    deleteIndex(ind2);
                    addIndext(temp3.Name, temp3.Price, ind2);
                }
            } else {
                deleteIndex(ind1);
                addIndext(temp2.Name, temp2.Price, ind1);
                deleteIndex(ind2);
                addIndext(temp1.Name, temp1.Price, ind2);
            }
        } else if (temp2.Price > temp3.Price) {
            deleteIndex(ind2);
            addIndext(temp3.Name, temp3.Price, ind2);
            deleteIndex(ind3);
            addIndext(temp2.Name, temp2.Price, ind3);
        }
    }
    void deletePrime(){
        int n=countPrime();
        Car cur = head;
        int i=0,ind=0;
        while(cur!=null && n!=0){
            if(checkPrime(cur.Price)==true){
                i++;
                if(i==1){
                    deleteIndex(ind);
                    ind--;
                }
                if(i==n){
                    deleteIndex(ind);
                    ind--;
                }
            }
            ind++;
            cur=cur.next;
        }
    }
}
