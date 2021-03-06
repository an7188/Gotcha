package com.ssafy.gotcha.game.model;

import java.util.HashMap;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameMessage extends MessageContent {
	private String gameSessionId; // 현재 게임방의 id
	private String hostId;	// 게임방의 호스트 id
	private List<String> turn;	// 게임 진행 순서(플레이어 id)
	private String picker;	// 뽑는 사람 id
	private String picked;	// 뽑히는 사람 id
	private HashMap<String, Player> players; // 현재 게임방에 참가한 플레이어 리스트
	private HashMap<String, List<Card>> cardList; // 현재 게임방에 참가한 플레이어의 카드
	private int timeCounter; //타이머

}