package BerelangPrimeNumber;

import java.io.*;
import java.util.*;

/*
 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 
 * */

public class BerelangPrimeNumber {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = 0;
		
		ArrayList list = new ArrayList<Integer>();
		
		while((num = Integer.parseInt(bf.readLine())) != 0) {
			
			int number = 2*num;
			int count = 0;
		
			
			Boolean[] bool = new Boolean[2*num+1];
			
			for(int i = 2; i <= number; i++) {
				bool[i] = true;
			}
			
			for(int i = 2; i * i <= number; i++ ) {
				if(bool[i]) {
					for(int j = i*i; j <= number; j+=i) {
						bool[j] = false;
					}
				}
			}
			
			//2부터 시쟉했기 때문에 번위에 벗어나는 것은 false로 
			for(int i = 1; i <=num; i++) {
				bool[i] = false;
			}
			
			for(int i = 2; i <= number; i++) {
				if(bool[i] == true) {
					count++;
				}
			}
			
			list.add(count);
		}
		
		for(int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
