package demo05;

import java.util.concurrent.atomic.AtomicInteger;

public class Message {
    private final static AtomicInteger RequestId = new AtomicInteger(1);

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    private transient byte[] body = new byte[0];

    public short getReqHandlerType() {
        return reqHandlerType;
    }

    public void setReqHandlerType(short reqHandlerType) {
        this.reqHandlerType = reqHandlerType;
    }

    private short reqHandlerType = 0; // Consumer | PRODUCER
    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    private int seqId = 0;
    public void setType(byte type) {
        this.type = type;
    }

    private byte type = 0;
    public static Message newRequestMessage() {
        Message msg = new Message();
        msg.setType((byte)1);
        msg.setSeqId(RequestId.getAndIncrement());
        return msg;
    }
    public static Message newResponseMessage() {
        Message msg = new Message();
        msg.setType((byte)2);
        msg.setSeqId(RequestId.getAndIncrement());
        return msg;
    }

    public static Message newExceptionMessage() {
        Message msg = new Message();
        msg.setType((byte)3);
        msg.setSeqId(RequestId.getAndIncrement());
        return msg;
    }
}
