package Task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskTest {

    private Task task;
    private final ArrayList<Task> listTask = new ArrayList<Task>();

    @Before
    public void init(){
        this.task = new Task( "Test", "contenu testé et validé", LocalDateTime.of(2021, 4, 29, 19, 45, 0));
    }

    @Test
    public void isContentValid() {
        Assert.assertTrue(this.task.isContentValid(this.task.getContent()));    }

    @Test
    public void isTimeTrue() {
        LocalDateTime lastDate = LocalDateTime.of(2021, 4, 29, 19, 10, 0);
        Assert.assertTrue(this.task.isThirtyMinutesOver(lastDate));    }

    @Test
    public void isTimeFalse() {
        LocalDateTime lastDate = LocalDateTime.of(2021, 4, 29, 19, 34, 0);
        Assert.assertFalse(this.task.isThirtyMinutesOver(lastDate));
    }

    @Test
    public void isTimeHourFalse() {
        LocalDateTime lastDate = LocalDateTime.of(2021, 4, 29, 20, 05, 0);
        Assert.assertFalse(this.task.isThirtyMinutesOver(lastDate));
    }

    @Test
    public void isTimeHourTrue() {
        LocalDateTime lastDate = LocalDateTime.of(2021, 4, 29, 20, 45, 0);
        Assert.assertTrue(this.task.isThirtyMinutesOver(lastDate));
    }
    @Test
    public void insertItemsFalse() {
        this.task = new Task( "Test", "contenu testé et validé", LocalDateTime.now());
        Assert.assertFalse(this.task.isTaskValid());
    }
    @Test
    public void getTenItems() {
        for(int i = 0; i < 10; i++) {
            if(this.task.isTaskValid()) {
                Assert.assertTrue(this.listTask.add(task));
            }
        }

        Assert.assertTrue(this.listTask.size() <= 10);
    }
    @Test
    public void moreTenItems() {
        for(int i = 0; i < 15; i++) {
            /* if(item.isTaskValid()) {
                Assert.assertTrue(this.listItem.add(item));
            } */
            Assert.assertTrue(this.listTask.add(task));
        }

        Assert.assertTrue(this.listTask.size() > 10);
    }
    @Test
    public void testSendMail() {
        if(this.listTask.size() > 8) {
            Assert.assertTrue(this.task.EmailSenderService());
        }
    }
}
