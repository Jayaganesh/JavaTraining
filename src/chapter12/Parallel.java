package chapter12;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Parallel {
    public static void main(String[] args) {
//        *** Concurrent Tasks ***

//        Running Tasks

        Runnable hellos = () -> {
            for (int i = 1; i <= 10000; i++)
                System.out.println("Hello " + i);
        };
        Runnable goodbyes = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Goodbye " + i);
        };

        ExecutorService executor = Executors.newCachedThreadPool();
//        executor.execute(hellos);
//        executor.execute(goodbyes);

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);


//        Futures

        ExecutorService executor1 = Executors.newFixedThreadPool(1);
        Callable<Integer> task = () -> 1;
        Future<Integer> f = executor1.submit(task);

        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        Set<Integer> paths = Set.of(1, 2, 3, 4);
        var tasks = new ArrayList<Callable<Integer>>();
        for (Integer p : paths)
            tasks.add(() -> p);

        List<Future<Integer>> futures = null;

        try {
            futures = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long total = 0;

        for (Future<Integer> f1 : futures) {
            try {
                total += f1.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(total);

//        invokeAny

//        Asynchronous Computations

//        Completable Futures

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "jg");
        f2.thenAccept(System.out::println);

//        f.whenComplete((s, t) -> {
//            if (t == null) { Process the result s; }
//            else { Process the Throwable t; }
//        });
//

//        var f = new CompletableFuture<Integer>();
//        executor.execute(() -> {
//            int n = workHard(arg);
//            f.complete(n);
//        });
//        executor.execute(() -> {
//            int n = workSmart(arg);
//            f.complete(n);
//        });
//
//        Throwable t = ...;
//        f.completeExceptionally(t);

//        Composing Completable Futures

//        public void CompletableFuture<String> readPage(URI url)
//        public static List<URI> getLinks(String page)

//        CompletableFuture<String> contents = readPage(url);
//        CompletableFuture<List<URI>> links = contents.thenApply(Parser::getLinks);

//        CompletableFuture<U> future.thenApply(f);
//        CompletableFuture<U> future.thenApplyAsync(f);

//        thenCompose

//        type T to the type U
//        T to CompletableFuture<U>

//        public String blockingReadPage(URI url)

//        public CompletableFuture<String> readPage(URI url)
//        public CompletableFuture<URI> getURLInput(String prompt)

//        CompletableFuture<String> contents = readPage(url)
//                .exceptionally(t -> { Log t; return emptyPage; });

//        Adding an Action to a CompletableFuture<T> Object

//        ====================================================================================================
//        Method	            Parameter	                Description
//        ====================================================================================================
//        thenApply	            T -> U	                    Apply a function to the result.
//        thenAccept	        T -> void	                Like thenApply, but with void result.
//        thenCompose	        T -> CompletableFuture<U>	Invoke the function on the result and execute the returned future.
//        thenRun	            Runnable	                Execute the Runnable with void result.
//        handle	            (T, Throwable) -> U	        Process the result or error and yield a new result.
//        whenComplete	        (T, Throwable) -> void	    Like handle, but with void result.
//        exceptionally	        Throwable -> T	            Turn the error into a default result.
//        exceptionallyCompose	Throwable -> CompletableFuture<U>	Invoke the function on the exception and execute the returned future.
//        completeOnTimeout	    T, long, TimeUnit	        Yield the given value as the result in case of timeout.
//        orTimeout	            long, TimeUnit	            Yield a TimeoutException in case of timeout.
//        ====================================================================================================

//        Combining Multiple Composition Objects

//        ====================================================================================================
//        Method	            Parameter	                Description
//        ====================================================================================================
//        thenCombine	        CompletableFuture<U>, (T, U) -> V	Execute both and combine the results with the given function.
//        thenAcceptBoth	    CompletableFuture<U>, (T, U) -> void	Like thenCombine, but with void result.
//        runAfterBoth	        CompletableFuture<?>, Runnable	Execute the runnable after both complete.
//        applyToEither	        CompletableFuture<T>, T -> V	When a result is available from one or the other, pass it to the given function.
//        acceptEither	        CompletableFuture<T>, T -> void	Like applyToEither, but with void result.
//        runAfterEither	    CompletableFuture<?>, Runnable	Execute the runnable after one or the other completes.
//        static allOf	        CompletableFuture<?>...	Complete with void result after all given futures complete.
//        static anyOf	        CompletableFuture<?>...	Complete after any of the given futures completes and yield its result.
//        ====================================================================================================

//        Long-Running Tasks in User-Interface Callbacks

//        var read = new JButton("Read");
//        read.addActionListener(event -> {
//            // Bad—long-running action is executed on UI thread
//            var in = new Scanner(url.openStream());
//            while (in.hasNextLine()) {
//                String line = in.nextLine();
//        ...
//            }
//        });

//        read.addActionListener(event -> {
//            // Good—long-running action in separate thread
//            Runnable task = () -> {
//                var in = new Scanner(url.openStream());
//                while (in.hasNextLine()) {
//                    String line = in.nextLine();
//            ...
//                }
//            }
//            executor.execute(task);
//        });

//        EventQueue.invokeLater(() -> message.appendText(line + "\n"));

//        *** Thread Safety ***

//        Visibility

//        private static boolean done = false;
//
//        public static void main(String[] args) {
//            Runnable hellos = () -> {
//                for (int i = 1; i <= 1000; i++)
//                    System.out.println("Hello " + i);
//                done = true;
//            };
//            Runnable goodbye = () -> {
//                int i = 1;
//                while (!done) i++;
//                System.out.println("Goodbye " + i);
//            };
//            Executor executor = Executors.newCachedThreadPool();
//            executor.execute(hellos);
//            executor.execute(goodbye);
//        }

//        The value of a final variable is visible after initialization.
//        The initial value of a static variable is visible after static initialization.
//        Changes to a volatile variable are visible.
//        Changes that happen before releasing a lock are visible to anyone acquiring the same lock (see Section 10.7.1, “Locks,” page 375).
//
//        In our case, the problem goes away if you declare the shared variable done with the volatile modifier:
//
//        private static volatile boolean done;

//        Race Conditions

//        for (int i = 1; i <= 100; i++) {
//            int taskId = i;
//            Runnable task = () -> {
//                for (int k = 1; k <= 1000; k++)
//                    count++;
//                System.out.println(taskId + ": " + count);
//            };
//            executor.execute(task);
//        }

//        Strategies for Safe Concurrency

//        confinement, immutability, and locking

//        *** Parallel Algorithms ***

//        long result = coll.parallelStream().filter(s -> s.startsWith("A")).count();

//        Threadsafe Data Structures

//        Concurrent Hash Maps
//        Blocking Queues

//      ***  Atomic Counters and Accumulators ***
//        AtomicLong

//        *** Locks and Conditions ***

//        Locks


//        public class Counter {
//            private final Lock countLock = new ReentrantLock();
//            // Shared among multiple threads
//            private int count = 0; // Shared among multiple threads
//
//            public int increment() {
//                countLock.lock();
//                try {
//                    count++; // Critical section
//                    return count;
//                } finally {
//                    countLock.unlock(); // Make sure the lock is unlocked
//                }
//            }
//        }

//        public synchronized void method() {
//            Body
//        }

//        is the equivalent of

//        public void method() {
//            this.intrinsicLock.lock();
//            try {
//                Body
//            } finally {
//                this.intrinsicLock.unlock();
//            }
//        }


//        Threads

//        Starting a Thread
//
//        Runnable task = () -> { ... };
//        var thread = new Thread(task);
//        thread.start();

//        thread.join(millis);


//        Thread Interruption

//        Runnable task = () -> {
//            while (more work to do) {
//                if (Thread.currentThread().isInterrupted()) return;
//                Do more work
//            }
//        };

//        Runnable task = () -> {
//            try {
//                while (more work to do) {
//                    Do more work
//                    Thread.sleep(millis);
//                }
//            }
//            catch (InterruptedException ex) {
//                // Do nothing
//            }
//        };

//        Thread-Local Variables


//        Processes

//        Building a Process

//        var builder = new ProcessBuilder("gcc", "myapp.c");

//        Process process = new ProcessBuilder("/bin/ls", "-l")
//                .directory(Path.of("/tmp").toFile())
//                .start();
//        try (var in = new Scanner(process.getInputStream())) {
//            while (in.hasNextLine())
//                System.out.println(in.nextLine());
//        }


//        int result = process.waitFor();

//        long delay = ...;
//        if (process.waitfor(delay, TimeUnit.SECONDS)) {
//            int result = process.exitValue();
//    ...
//        } else {
//            process.destroyForcibly();
//        }

//        process.onExit().thenAccept(
//                p -> System.out.println("Exit value: " + p.exitValue()));


    }


}
