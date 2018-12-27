package homework_2;

import java.util.Arrays;

/**
 * @autor Kunakbaev Artem
 */
class MyArray {
    private int[] myArray;

    MyArray(int length) {
        myArray = new int[length];
        for (int i = 0; i < length; i++) {
            myArray[i] = (int) (Math.random() * 100);
        }
    }

    int[] getMyArray() {
        return myArray;
    }

    void setMyArray(int[] myArray) {
        this.myArray = myArray;
    }

    private void printArray() {
        System.out.println(Arrays.toString(myArray));
    }

    private int findElementIndex(int element) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == element) {
                System.out.println("Найден элемент с индексом " + i);
                return i;
            }
        }
        System.out.println("Элемент не найден");
        return -1;
    }

    void deleteElement(int element) {
        int removeIndex = findElementIndex(element);
        if (removeIndex != -1) {
            int[] newArray = new int[myArray.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                if (i < removeIndex) {
                    newArray[i] = myArray[i];
                } else {
                    newArray[i] = myArray[i + 1];
                }
            }
            myArray = newArray;
            printArray();
        }
    }

    void addElement(int index, int element) {
        int[] newArray = new int[myArray.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = myArray[i];
            } else if (i == index) {
                newArray[i] = element;
            } else {
                newArray[i] = myArray[i - 1];
            }
        }
        myArray = newArray;
        printArray();
    }
}

