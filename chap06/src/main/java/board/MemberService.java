package board;

public interface MemberService {

	void regist(MemberRegRequest memberRegReq);
	
	boolean update(String id, UpdateInfo updateInfo);
}
