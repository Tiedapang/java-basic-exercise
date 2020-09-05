package main.java;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
    	//需要从命令行读入
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入两行测试数据");
    	//输入第一行测试数据
        String firstWordList = sc.nextLine();
        //输入第二行测试数据
        String secondWordList = sc.nextLine();
        //将两行输入数据代入到测试函数测试
        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //将单词串按字母顺序排序去掉重复单词输出（重复单词不区分大小写）
        System.out.println(Arrays.toString(result.toArray()));

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
    	//如果字符串中出现非字母或者连续逗号，则抛出运行时异常，异常信息：input not
    	if(!isAlphabetic(firstWordList)||!isAlphabetic(secondWordList)) {
    		throw new RuntimeException("input not");
    	};
    	List<String> firstList = java.util.Arrays.asList(firstWordList.toUpperCase().replaceAll("([A-Za-z])([A-Za-z])", "$1 $2 ").split(","));;
    	List<String> secondList = java.util.Arrays.asList(secondWordList.toUpperCase().replaceAll("([A-Za-z])([A-Za-z])", "$1 $2 ").split(",")); 	
    	List<String> resultList = (List)firstList.stream().filter(it->secondList.contains(it))
        		.distinct().collect(Collectors.toList());   	
    	return resultList;
    }


   /**
    * 判读输入字符串中是否含有特殊字符
* @param s 输入字符串
* @return true:不含有 
*         false:含有
*/
   private static boolean isAlphabetic(String s) {
	   Pattern p = Pattern.compile("^[A-Za-z]*([A-Za-z]+[,])*([A-Za-z]+)$");
	   Matcher m = p.matcher(s);
	   return m.matches();	
   }
}
