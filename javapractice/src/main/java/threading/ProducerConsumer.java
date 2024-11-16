package main.java.threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Producer producer = new Producer(producerConsumer.queue);
        producer.start();
        Consumer consumer = new Consumer(producerConsumer.queue);
        consumer.start();
    }
}

class Producer extends Thread {

    private final Queue<Integer> queue;
    Integer i = 0;

    public Producer(Queue<Integer> input) {
        this.queue = input;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 10) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Got exception while waiting");
                    }
                }
                queue.add(i++);
                System.out.println("Adding element to the queue " + i);
                queue.notifyAll();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}

class Consumer extends Thread {

    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Polling the element from queue " + queue.poll());
                queue.notifyAll();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
