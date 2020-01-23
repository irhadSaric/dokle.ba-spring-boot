create PROCEDURE ADD_PATH_V8(
    id_in IN USERS.ID%TYPE,
    date_in IN varchar2,
    time_in IN varchar2,
    country_in IN PATHS.COUNTRY_ID%TYPE,
    starting_point_in IN PATHS.STARTING_POINT%TYPE,
    destination_in IN PATHS.DESTINATION%TYPE,
    payment_in IN PATHS.PAYMENT_ID%TYPE
)
    IS
    var_path_id PATHS.ID%TYPE;
BEGIN
    INSERT INTO PATHS (DEPARTURE_DATE, DEPARTURE_TIME, COUNTRY_ID, STARTING_POINT, DESTINATION, PAYMENT_ID)
    VALUES (to_timestamp(date_in, 'yyyy-mm-dd hh24:mi:ss.ff'), to_timestamp(time_in, 'yyyy-mm-dd hh24:mi:ss.ff'), country_in, starting_point_in, destination_in, payment_in) RETURNING PATHS.ID INTO var_path_id;

    INSERT INTO USER_PATHS (USER_ID, PATH_ID) VALUES (id_in, var_path_id);
end;
/

