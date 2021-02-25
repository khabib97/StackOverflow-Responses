import java.util.ArrayList;
import java.util.List;

public class MemoryChecker {
	
	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) {
        List<Load> list = new ArrayList<Load>();
        for (int i = 0; i <= 1500000
                ; i++) {
            list.add(new Load("Jim", "Knopf", 11L));
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
    }

}

class Load {
    public Load(String name, String title, Long id) {
    	this.name = name;
    	this.title = title;
    	this.id = id;
	}
	String name;
    String title;
    Long id;
}
