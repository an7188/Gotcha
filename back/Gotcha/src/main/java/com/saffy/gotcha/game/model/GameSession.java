package com.saffy.gotcha.game.model;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameSession {
	private String gameSessionId; // ���� ���ӹ��� id
	private HashMap<String, Player> players; // ���� ���ӹ濡 ������ �÷��̾� ����Ʈ
	private String hostId;
//	private GameManager gameMgr; // ���õ� ������ ������ Mgr.  TODO: �߰��ؾ���.

	public GameSession(String gameSessionId, Player hostPlayer) {
		this.gameSessionId = gameSessionId;
		players = new HashMap<String, Player>();
		players.put(hostPlayer.getUserId(), hostPlayer); // UUID , ��������
	}

// TODO: �����ؾ���
//	public void setGameManager(String TYPE) {
//		switch (TYPE) {
//		case "DODUK":
//			gameMgr = new DodukGameManager(this.players);
//			break;
//		case "LIAR":
//			gameMgr = new LiarGameManager(this.players);
//			break;
//		}
//	}
}
