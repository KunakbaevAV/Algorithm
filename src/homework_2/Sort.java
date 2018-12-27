package homework_2;

/**
 * @autor Kunakbaev Artem
 */
class Sort {
    private static long timer;

    static int[] bubleSort(int[] array) {
        System.out.println("Пузырьковая сортировка");
        startTimer();
        int in, out;
        for (out = array.length - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    change(array, in, out);
                }
            }
        }
        stopTimer();
        return array;
    }

    static int[] selectSort(int[] array) {
        System.out.println("Сортировка методом выбора");
        startTimer();
        int in, out, mark;
        for (out = 0; out < array.length; out++) {
            mark = out;
            for (in = out + 1; in < array.length; in++) {
                if (array[in] < array[mark]) {
                    mark = in;
                }
            }
            change(array, out, mark);
        }
        stopTimer();
        return array;
    }

    static int[] insertSort(int[] array) {
        System.out.println("Сортировка методом вставки");
        startTimer();
        int in, out;
        for (out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
        stopTimer();
        return array;
    }

    private static void startTimer() {
        timer = System.currentTimeMillis();

    }

    private static void stopTimer() {
        long time = System.currentTimeMillis() - timer;
        System.out.println("Прошло миллисекунд: " + time);
    }


    private static void change(int[] array, int in, int out) {
        int temp = array[in];
        array[in] = array[out];
        array[out] = temp;
    }
}

