package employees;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReader implements Reader<Member> {
    private final String filePath;

    public EmployeeReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Member> readFileToList() {
        return new ArrayList<>();
    }
}
