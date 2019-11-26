import com.fourinone.Contractor;
import com.fourinone.WareHouse;
import com.fourinone.WorkerLocal;
import java.util.ArrayList;

public class SimpleCtor extends Contractor
{
	// warehouse 类似消息队列，即放任务，又存输入输出数据，后者需要实现序列化
	// 职介者就是ParkServer，类似调度器，回调函数，
	public WareHouse giveTask(WareHouse inhouse)
	{
		// get workers instance (ref)
		WorkerLocal[] wks = getWaitingWorkers("simpleworker");
		System.out.println("wks.length:"+wks.length);
		
		// send a type of word, named hujun
		WareHouse wh = new WareHouse("word", "HUJUN");
		// let worker do task
		WareHouse result = wks[0].doTask(wh);

		while(true){
			// never run here, cause not set ready
			if(result.getStatus()==WareHouse.READY)
			{
				System.out.println("result:"+result);
				break;
			}
		}

		return null;
	}
	
	public static void main(String[] args)
	{
		SimpleCtor a = new SimpleCtor();
		a.giveTask(null);
	}
}