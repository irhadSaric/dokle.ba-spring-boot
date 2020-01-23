create PROCEDURE ADD_MESSAGE(
    receiver_id_in IN USER_MESSAGES.RECEIVER_ID%TYPE,
    sender_id_in IN USER_MESSAGES.SENDER_ID%TYPE,
    message_text_in IN MESSAGES.MESSAGE_TEXT%TYPE,
    message_time_in IN varchar2)
    IS
    var_message_id MESSAGES.ID%TYPE;
BEGIN
    INSERT INTO MESSAGES (MESSAGE_TEXT, SENDING_TIME, STATUS_ID)
    VALUES (message_text_in, to_timestamp(message_time_in, 'yyyy-mm-dd hh24:mi:ss.ff'), 41)
    RETURNING MESSAGES.ID into var_message_id;

    INSERT INTO USER_MESSAGES (SENDER_ID, RECEIVER_ID, MESSAGE_ID)
    VALUES (sender_id_in, receiver_id_in, var_message_id);

    COMMIT;
END;
/

