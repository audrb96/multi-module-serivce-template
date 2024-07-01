package user.application.service.query;

import user.domain.vo.UserId;

public class GetUserByIdQuery {

	private final Long userId;

	public GetUserByIdQuery(Long userId) {
		this.userId = userId;
	}

	public UserId toUserId() {
		return new UserId(this.userId);
	}
}
