package com.redis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.ShardedJedis;

import com.redis.test.RedisUtil;


/**
 * 读取redis中的全部，然后根据状态来进行改变
 * 这里主要是对redis中的hash的操作 - 首先模拟插入，然后是读取全部的数据，最后是根据某一个条件去进行相应的修改
 * @author zhengYu
 *
 */
public class TestRedis2 {
	ShardedJedis jedis;

	//关于对redis的数据的测试
	public void inertHash(){
		try {
			//前面是插入数据哈，假设我插入的是一个人，目前只有 名字和年龄，还有一个编号哈
			jedis = RedisUtil.getJedis();
			//0->插入，1->修改,2->已查阅
			//目前的需求是这样的，查询所有的数据，如果是非2的话，我就打印出来，然后把它的状态改成2，就表示已经阅读了哈
			//我插入6条数据哈
			jedis.del("person");  //首先全部删除数据
			//jedis.hset表示的是一条数据一条数据的插入,hmset是可以多条，这里就只是考虑一条数据了吧
			Long string = jedis.hset("person", "person001", "xiaoyu1,36,0");
			jedis.hset("person", "person002", "xiaoyu2,32,2");
			jedis.hset("person", "person003", "xiaoyu3,11,1");
			jedis.hset("person", "person004", "xiaoyu4,21,2");
			jedis.hset("person", "person005", "xiaoyu5,61,0");
			jedis.hset("person", "person006", "xiaoyu6,77,1");
			System.out.println("str:"+string);
			RedisUtil.returnResource(jedis); //每次查询完了之后要进行释放才行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//读取，这里我还是放到一个类里面去比较好点哈，主要是好比较的嘛
	public List<TestRedisEntity> readHash(){
		List<TestRedisEntity> list = new ArrayList<TestRedisEntity>();
		jedis = RedisUtil.getJedis(); //创建redis的实体
		//读取redis中的hash
		Map<String, String> map = new HashMap<String, String>();
		map = jedis.hgetAll("person");
		  System.out.println("通过Map.entrySet遍历key和value"); //从结果我可以看出，map是没有顺序的
		  for (Map.Entry<String, String> entry : map.entrySet()) {
			  //System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			  //现在我们把结果放到集合里面去，这里如果目前没有简便方法，那就用老方法哈，反正不管怎么样，要把东西给弄出来
			  TestRedisEntity testRedisEntity = new TestRedisEntity();
			  testRedisEntity.setKeyname(entry.getKey().toString());  //key是一定不为null，但是其他的参数就可能是null哈
			  String value = entry.getValue();
			  String[] strs = value.split(",");  //根据,分隔,但是要注意最后一个逗号的后面是必须要有值的才行
			  testRedisEntity.setName(strs[0]);
			  testRedisEntity.setAge(Integer.parseInt(strs[1]));
			  testRedisEntity.setNumber(Integer.parseInt(strs[2]));
			  list.add(testRedisEntity); //插入到list里面去
		  } 
		  RedisUtil.returnResource(jedis); //每次查询完了之后要进行释放才行
		  return list;
	}
	//根据条件来进行操作  ,如果不是number测试的，1，把它打印出来，2，然后去改变它才行
	public <T> void byCondition(List<T> list,int number){
		List<TestRedisEntity> listc = (List<TestRedisEntity>) list;
		for(int i=0;i<listc.size();i++){
			TestRedisEntity t = listc.get(i);
			if(t.getNumber() != number){
				//1打印出来
				System.out.println("该记录没有被读取:"+t.toString());
				//2改变状态
				jedis = RedisUtil.getJedis(); //创建redis的实体
				//这里的改变就是重新插入一条记录就会把以前的记录给覆盖掉
				jedis.hset("person", t.getKeyname(), t.getName()+","+t.getAge()+","+number);
				RedisUtil.returnResource(jedis); //每次查询完了之后要进行释放才行
			}
			
		}
		System.out.println("修改成功，小伙伴快去你的数据库看看吧！");
	}
	
	public static void main(String[] args) {
		TestRedis2 t = new TestRedis2();
		t.inertHash(); //插入到redis中的hash
		List<TestRedisEntity>  list = t.readHash();  //全部插入到redis成功了哈
		System.out.println("listsize:"+list.size());
		System.out.println("随便找一个来测试下哈:"+list.get(2).getKeyname());
		
		//最后一个是根据条件来进行操作，根据条件来进行操作
		int number = 2;
		t.byCondition(list, number);
		
	}
}
