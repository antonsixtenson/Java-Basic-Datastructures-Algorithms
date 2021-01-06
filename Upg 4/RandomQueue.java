import java.util.Random;

public class RandomQueue {



    private static int size;
    private static ListNode front;
    private static ListNode back;

    public RandomQueue() {
        front = back = null;

    }


    public boolean isEmpty() {

        if (front == null)return true;

        return false;
    }


    public  void enqueue(Object o){
        ListNode lstNd = new ListNode((String)o);
        if(isEmpty()) {
            front = lstNd;
            back = lstNd;
            size++;
            return;
        }
        else {
            back.next = lstNd;
            back =back.next;
            size++;

        }

    }

    public  Object dequeue() {
        //Random rand = new Random();
        String retEl;
        if(isEmpty())
        throw new UnderflowException("empty queue");
        else {

            int random = (int)(Math.random()*size+1);
            //int random = rand.nextInt(size+1) + size;
            if(random==1) {
                retEl = front.element;
                front = front.next;
                size--;
                return retEl;
            }
            else {
                ListNode temp = front;
                ListNode prev =null;

                for(int i = 0; i < random-1; i++) {
                    prev = temp;
                    temp = temp.next;

                }
                retEl = temp.element;
                prev.next = prev.next.next;
                size--;
                return retEl;
            }
        }
    }

    public static void main(String[] CmdLn) {

        RandomQueue randQueue  = new RandomQueue();
        randQueue.enqueue("elem1");
        randQueue.enqueue("elem2");
        randQueue.enqueue("elem3");
        randQueue.enqueue("elem4");
        randQueue.enqueue("elem5");
        //System.out.println("TEST");
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());








    }

}
