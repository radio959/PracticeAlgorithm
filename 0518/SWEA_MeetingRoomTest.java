package com.ssafy.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
10
1 1 4
2 1 6
3 6 10
4 5 7
5 3 8
6 5 9
7 3 5
8 8 11
9 2 13
10 12 14

*/
public class MeetingRoomTest {
	static class MeetingRoom implements Comparable<MeetingRoom> {
		int no, start, end;

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

//		(1,1,2) (2,2,3) (3,3,3) 만약 정보가 이렇게 주어진다면 종료시간 기준으로 정렬했을 때 가능한 회의는 총 3개가 찍힘
//		(1,1,2) (3,3,3) (2,2,3) 근데 이렇게 주어진다면 종료시간 기준으로 정렬했을 때 가능한 회의는 총 2개
//		그러므로 종료시간이 같다면 시작시간이 빠른 순대로 정렬해주는 로직이 필요
		@Override
		public int compareTo(MeetingRoom o) {
			int diff = this.end - o.end;
			return diff != 0 ? diff : this.start - o.start;
		}

		@Override
		public String toString() {
			return "MeetingRoom [no=" + no + ", start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		MeetingRoom[] m = new MeetingRoom[N];

		for (int i = 0; i < N; i++) {
			m[i] = new MeetingRoom(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		List<MeetingRoom> list = getSchedule(m);
		for(MeetingRoom mr : list) {
			System.out.println(mr);
		}
	}

	public static List<MeetingRoom> getSchedule(MeetingRoom[] m) {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();

		// 한번 정렬해서 받음.
		Arrays.sort(m);
		list.add(m[0]); // 첫 회의는 무조건 배정
		for (int i = 1, size = m.length; i < size; i++) {
			// 리스트에 담긴 마지막 요소의 종료시간이 m의 시작시간보다 작거나 같다. (=겹치지 않는다면)
			if(list.get(list.size()-1).end<=m[i].start) { 
				list.add(m[i]); // 리스트에 m[i]번째 회의를 넣는다.
			}
		}
		return list;
	}
}
