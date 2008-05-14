package org.jsmpp.session;

import java.io.IOException;

import org.jsmpp.bean.Bind;
import org.jsmpp.bean.BindType;
import org.jsmpp.bean.CancelSm;
import org.jsmpp.bean.MessageState;
import org.jsmpp.bean.QuerySm;
import org.jsmpp.bean.ReplaceSm;
import org.jsmpp.bean.SubmitMulti;
import org.jsmpp.bean.SubmitMultiResult;
import org.jsmpp.bean.SubmitSm;
import org.jsmpp.extra.ProcessRequestException;
import org.jsmpp.util.MessageId;

/**
 * @author uudashr
 * 
 */
public interface ServerResponseHandler extends BaseResponseHandler {
    void sendBindResp(String systemId, BindType bindType, int sequenceNumber)
            throws IOException;

    void sendSubmitSmResponse(MessageId messageId, int sequenceNumber)
            throws IOException;

    void processBind(Bind bind);

    MessageId processSubmitSm(SubmitSm submitSm) throws ProcessRequestException;
    
    SubmitMultiResult processSubmitMulti(SubmitMulti submitMulti) throws ProcessRequestException;
    
    void sendSubmitMultiResponse(SubmitMultiResult submiitMultiResult,
            int sequenceNumber) throws IOException;
    
    QuerySmResult processQuerySm(QuerySm querySm)
            throws ProcessRequestException;

    void sendQuerySmResp(String messageId, String finalDate,
            MessageState messageState, byte errorCode, int sequenceNumber)
            throws IOException;

    void processCancelSm(CancelSm cancelSm) throws ProcessRequestException;
    
    void sendCancelSmResp(int sequenceNumber) throws IOException;
    
    void processReplaceSm(ReplaceSm replaceSm) throws ProcessRequestException;
    
    void sendReplaceSmResp(int sequenceNumber) throws IOException;
}