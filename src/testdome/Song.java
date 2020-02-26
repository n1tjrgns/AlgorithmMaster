package testdome;
/*A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist. Otherwise, the playlist will end with the last song which points to null.

Implement a function isRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.

For example, the following code prints "true" as both songs point to each other.
재생 목록에는 재생 목록의 이전 곡에 대한 참조가 포함된 곡이 있으면 재생 목록은 반복 재생 목록으로 간주된다.
그렇지 않으면 재생 목록은 null을 가리키는 마지막 곡으로 끝날 것이다.

기능 구현 isRepeatingPlaylist 사용 시간과 관련하여 효율적으로 재생 목록이 반복되는 경우 true를 반환하고
재생 목록이 없으면 false를 반환하는 기능 구현.

예를 들어, 다음 코드는 두 곡이 서로를 가리키면서 "true"를 인쇄한다.*/

//https://stackoverflow.com/questions/2663115/how-to-detect-a-loop-in-a-linked-list
//https://opentutorials.org/module/1335/8857  -> 노드를 사용한 링크드리스트 구현
//노드에 대해 다시 공부 후 풀이
//https://www.journaldev.com/23049/linked-list-loop-detection-floyds-cycle-finding-algorithm

//이런 문제를 Floyd's Cycle-Finding Algorithm 이라고 부른다.
//리스트의 구조가 순환 형태인지 아닌지 알아내는 방법
//시간 복잡도 O(n)
//속도가 다른 두 개의 포인터를 루프에 진입시켜 진행 하다보면 순환 일 경우 결국 같은 노드를 가르킨다.
public class Song{
    private String name; //data
    private Song nextSong; //next

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {

        Song head = nextSong;

        Song slow = head;
        Song fast = head;

        boolean loop = false;

        while(slow != null && fast != null && fast.nextSong != null){
            slow = slow.nextSong;
            fast = fast.nextSong.nextSong;

            if(slow == fast){
                loop = true;
                break;
            }
        }

        return loop;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}