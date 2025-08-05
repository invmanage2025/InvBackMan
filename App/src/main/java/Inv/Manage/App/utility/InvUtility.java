package Inv.Manage.App.utility;

import java.util.ArrayList;
import java.util.List;

public class InvUtility {

	
	public static InvMessage.Type getHighestType(List<InvMessage> allMessages){
		
		List<InvMessage> errorMsgList = InvUtility.getErrorMessages(allMessages);
		if(errorMsgList != null && !errorMsgList.isEmpty()) {
			return InvMessage.Type.ERROR;
		}
		
		List<InvMessage> warningMsgList = InvUtility.getWarnMessages(allMessages);
		if(warningMsgList != null && !warningMsgList.isEmpty()) {
			return InvMessage.Type.WARNING;
		}
		
		List<InvMessage> infoMsgList = InvUtility.getInfoMessages(allMessages);
		if(infoMsgList != null && !infoMsgList.isEmpty()) {
			return InvMessage.Type.INFO;
		}
		
		return null;
	}
	
	public static List<InvMessage> getErrorMessages(List<InvMessage> allMessages){
		List<InvMessage> errorMsgList = new ArrayList<>();
		
		if(allMessages != null && !allMessages.isEmpty()) {
			for(InvMessage msg : allMessages) {
				if(msg.type.equals(InvMessage.Type.ERROR)) {
					errorMsgList.add(msg);
				}
			}
		}
		return errorMsgList;
	}
	
	public static List<InvMessage> getInfoMessages(List<InvMessage> allMessages){
		List<InvMessage> infoMsgList = new ArrayList<>();
		
		if(allMessages != null && !allMessages.isEmpty()) {
			for(InvMessage msg : allMessages) {
				if(msg.type.equals(InvMessage.Type.INFO)) {
					infoMsgList.add(msg);
				}
			}
		}
		return infoMsgList;
	}
	
	public static List<InvMessage> getWarnMessages(List<InvMessage> allMessages){
		List<InvMessage> warningMsgList = new ArrayList<>();
		
		if(allMessages != null && !allMessages.isEmpty()) {
			for(InvMessage msg : allMessages) {
				if(msg.type.equals(InvMessage.Type.WARNING)) {
					warningMsgList.add(msg);
				}
			}
		}
		return warningMsgList;
	}
}
