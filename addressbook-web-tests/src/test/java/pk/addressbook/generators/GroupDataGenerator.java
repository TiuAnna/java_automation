package pk.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import pk.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class GroupDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
        jCommander.parse(args);

        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        ArrayList<GroupData> groups = generateGroups(count);
        save(groups, new File(file));
    }

    private void save(ArrayList<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group : groups) {
            writer.write(String.format("%s,%s,%s\n",group.name(), group.header(), group.footer()));
        }
        writer.close();
    }

    private ArrayList<GroupData> generateGroups(int count) {
        ArrayList<GroupData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
