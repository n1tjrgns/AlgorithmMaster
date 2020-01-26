package programmers.skillchecktest;

import java.util.Arrays;

public class SkillTree2 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++){
            boolean flag = true;

            String[] skills = skill_trees[i].split("");
            System.out.println(Arrays.toString(skills));

            //처음에 선행스킬을 0, 제일 앞 스킬 보다 크면 break
            int cnt = 0;
            for(int j=0; j<skills.length; j++){
                if( cnt < skill.indexOf(skills[j])){
                    flag = false;
                    break;
                }else if ( cnt == skill.indexOf(skills[j])){
                    cnt++;
                }
            }

            if(!flag){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SkillTree2 s = new SkillTree2();
        System.out.println(s.solution("CBD", new String[]{"BACDE","CBADF","AECB","BDA"}));
    }
}
