package inflearn.stringarray.sec1;



import java.util.Arrays;

//현재 배열을 복사하거나 재할당하지 않고 0을 제외한 나머지 수들은 현재 순서를 유지한 체로 재정렬
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        /*int[] answer = new int[nums.length];
        Arrays.fill(answer, 0);

        int index = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                answer[index] = nums[i];
                index++;
            }
        }

        for (int i=0; i<answer.length; i++){
            nums[i] = answer[i];
        }

        System.out.println("answer = " + Arrays.toString(answer));
        */
        //이렇게 하면 답은 맞지만, 문제에서는 배열을 복사하지 말라했으니 추가 생성 없이 답을 구해야 맞는것같음
        int idx=0;
        for (int num : nums) {
            if (num !=0){
                nums[idx++] = num;
            }
        }

        while (idx < nums.length){
            nums[idx++] = 0;
        }
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeros moveZeroes = new MoveZeros();
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
    }
}
