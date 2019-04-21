package offer;

/**
 * 旋转数组的最小数字
 * 数组{3, 4, 5, 1, 2} 为{1, 2, 3, 4, 5}的一个旋转， 该数组最小为1
 * @author PHS
 * @create 2019-03-30 15:48
 **/
public class Question11 {

    public static void main(String[] argc) {

    }

    private static int Min(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        //第一个记数
        int index1 = 0;
        //最后一个记数
        int index2 = numbers.length - 1;
        //中间的记数
        int indexMid = index1;
        //拆半 旋转后，前面的数字总是大于等于后面的数字
        while (numbers[index1] >= numbers[index2]) {
            //所有元素都遍历完
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) >> 2;

            //如果第一个 中间 最后一个数字相等 这种情况只能遍历数组
            if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1]) {
                return minInOrder(numbers, index1, index2);
            }

            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }


    private static int minInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}
