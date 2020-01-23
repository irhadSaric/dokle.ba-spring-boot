create PROCEDURE "FILTER_PATHS_TEST_2"
(starting_point_in IN PATHS.STARTING_POINT%TYPE,
 destination_in IN PATHS.DESTINATION%TYPE,
 departure_date_in IN varchar2,
 departure_time_in IN varchar2,
 country_in IN PATHS.COUNTRY_ID%TYPE,
 payment_in IN PATHS.PAYMENT_ID%TYPE,
 response OUT SYS_REFCURSOR
)
    IS
    CURSOR C IS
        SELECT P.*,
               C2.NAME AS "CountryName",
               P2.NAME AS "PaymentType",
               U.FIRST_NAME,
               U.ID AS "UserId",
               D.AVATAR
        FROM PATHS P
                 INNER JOIN COUNTRIES C2 on P.COUNTRY_ID = C2.ID
                 INNER JOIN PAYMENTS P2 on P.PAYMENT_ID = P2.ID
                 INNER JOIN USER_PATHS UP on P.ID = UP.PATH_ID
                 INNER JOIN USERS U on UP.USER_ID = U.ID
                 INNER JOIN USER_DETAILS ON U.ID = USER_DETAILS.USER_ID
                 INNER JOIN DETAILS D ON USER_DETAILS.DETAIL_ID = D.ID;
BEGIN
    DELETE FROM POMOCNA_TABELA_2;

    FOR R IN C LOOP
            IF(R.STARTING_POINT = NVL(starting_point_in, R.STARTING_POINT) AND R.DESTINATION = NVL(destination_in, R.DESTINATION)
                AND R.PAYMENT_ID = NVL(payment_in, R.PAYMENT_ID) AND R.COUNTRY_ID = NVL(country_in, R.COUNTRY_ID)
                AND R.DEPARTURE_DATE = NVL(to_timestamp(departure_date_in, 'yyyy-mm-dd hh24:mi:ss.ff'), R.DEPARTURE_DATE)
                AND R.DEPARTURE_TIME=NVL(to_timestamp(departure_time_in, 'yyyy-mm-dd hh24:mi:ss.ff'), R.DEPARTURE_TIME)) THEN
                INSERT INTO POMOCNA_TABELA_2 (ID, STARTING_POINT, DESTINATION, DEPARTURE_DATE, DEPARTURE_TIME, COUNTRY_ID,
                                              PAYMENT_ID, COUNTRY_NAME, PAYMENT_TYPE, FIRST_NAME, USER_ID, AVATAR)
                VALUES(R.ID, R.STARTING_POINT,R.DESTINATION, R.DEPARTURE_DATE, R.DEPARTURE_TIME, R.COUNTRY_ID,
                       R.PAYMENT_ID, R."CountryName", R."PaymentType", R.FIRST_NAME, R."UserId", R.AVATAR);
            END IF;
        END LOOP;

    OPEN response FOR SELECT * FROM POMOCNA_TABELA_2;

    COMMIT;
END;
/

