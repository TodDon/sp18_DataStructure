import java.util.Objects;

public class LinkedListDeque<LochNess>{
    public class stuffNode{
        public LochNess item;
        public stuffNode next;
        public stuffNode last;

        public stuffNode(LochNess i, stuffNode n, stuffNode l){
            item = i;
            next = n;
            last = l;
        }
    }
    public stuffNode fsentinel;
    public stuffNode tsentinel;
    private int size;

    public  LinkedListDeque(){
        size=0;
        fsentinel=new stuffNode(null,null,null);
        tsentinel=new stuffNode(null,null,fsentinel);
        fsentinel.next=tsentinel;
    }

    public LinkedListDeque(LochNess i){
        size=1;
        fsentinel=new stuffNode(null, null, null);
        tsentinel=new stuffNode(null, null, null);
        stuffNode tmp = new stuffNode(i,tsentinel,fsentinel);
        fsentinel.next=tmp;
        tsentinel.last=tmp;

    }

    public void addFirst(LochNess i){
        size+=1;
        stuffNode tmp=new stuffNode(i,fsentinel.next,fsentinel);
        fsentinel.next.last=tmp;
        fsentinel.next=tmp;
    }

    public void addLast(LochNess i){
        size+=1;
        stuffNode tmp=new stuffNode(i,tsentinel,tsentinel.last);
        stuffNode temp=tsentinel.last;
        temp.next = tmp;
        tsentinel.last=tmp;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        stuffNode p=fsentinel.next;
        System.out.println();
        while(p!=tsentinel){
            System.out.print(p.item);
            System.out.print(' ');
            p=p.next;
        }
        System.out.println();
    }

    public LochNess removeFirst(){
        stuffNode p=fsentinel.next;
        if(p==tsentinel)
            return null;
        else{
            fsentinel.next=p.next;
            fsentinel.next.last=fsentinel;
            return p.item;
        }
    }

    public LochNess removeLast(){
        stuffNode p=tsentinel.last;
        if(p==fsentinel)
            return null;
        else{
            tsentinel.last=p.last;
            tsentinel.last.next=tsentinel;
            return p.item;
        }
    }

    public LochNess get(int index){
        int i=0;
        stuffNode p=fsentinel.next;
        while(p!=tsentinel){
            if(i==index){
                return p.item;
            }
            i+=1;
            p=p.next;
        }
        return null;
    }

    private LochNess forGetRecursive(stuffNode p,int index){
        if(p==null)
            return null;
        else if(index==0)
            return p.item;
        else
            return forGetRecursive(p.next,index-1);
    }
    public LochNess getRecursive(int index){
        return forGetRecursive(fsentinel.next,index);
    }
}
