INSERT INTO "timeDeposits" (plan_type, days, balance)
VALUES ('STANDARD', 30, 1000.00);

INSERT INTO "timeDeposits" (plan_type, days, balance)
VALUES ('PREMIUM', 90, 5000.00);

INSERT INTO "withdrawals" (time_deposit_id, amount, date)
VALUES (1, 100.00, '2026-03-10');

INSERT INTO "withdrawals" (time_deposit_id, amount, date)
VALUES (2, 250.00, '2026-03-11');