package employees;
import java.util.ArrayList;
import java.util.List;

public class MemberReader implements Reader<Member> {
    private final String filePath;

    public MemberReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Member> readFileToList() {
        return new ArrayList<>();
    }
}
