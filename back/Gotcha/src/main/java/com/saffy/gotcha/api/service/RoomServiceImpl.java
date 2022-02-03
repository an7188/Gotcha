package com.saffy.gotcha.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saffy.gotcha.api.request.RoomRegisterPostReq;
import com.saffy.gotcha.entity.Room;
import com.saffy.gotcha.entity.User;
import com.saffy.gotcha.repository.GameSessionRepository;
import com.saffy.gotcha.repository.RoomRepository;
import com.saffy.gotcha.repository.UserRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private UserRepository userRopository;
	
	@Autowired
	private GameSessionRepository gameSessionRepository;
	
	
	@Override
	public Room createRoom(RoomRegisterPostReq roomRegisterPostReq) {
		User host = userRopository.findByUserId(roomRegisterPostReq.getHostId());
		
		String gameSessionId = UUID.randomUUID().toString(); // �������� �������ֱ�
		
		Room room = Room.builder()
				  .roomId(gameSessionId)  // ������ ���̵� �ϳ� �����ؼ� �־��ֱ�. �̳��� sessionId�� �����ؾ� ��.
				  .password(roomRegisterPostReq.getPassword())
						.roomTitle(roomRegisterPostReq.getRoomTitle())
						.createdAt(LocalDateTime.now())
						.isPrivate(roomRegisterPostReq.isPrivate())
						.capacity(roomRegisterPostReq.getCapacity())
						.participant(1) // ������ ���ٰ� �����ؾ��ϴϱ�
						.isFull(false)
						.isRun(false)
						.build();
		
		gameSessionRepository.createGameSession(gameSessionId, host.toPlayer());
		
		return roomRepository.save(room);
	}

	@Override
	public List<Room> getRooms() {
		return roomRepository.findAll();
	}

}
