import java.util.ArrayList;

//Class (this ref) outer this ref knows about inner this ref, also inner this ref know outer this ref
//        ---> other class (nested class) (this ref)
public class Network {
    public class Member { // Member is an inner class of Network
        private String name;
        private ArrayList<Member> friends;

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", friends=" + friends +
                    '}';
        }

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void deactivate() {
            Network.this.unenroll(this);
        }
    }

    public ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name) {
        var newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }


    public void unenroll(Member m) {
        members.remove(m);
    }

}