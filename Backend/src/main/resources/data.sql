insert into client
values
(1, 'Client A'),
(2, 'Client B'),
(3, 'Client C');

insert into productarea
values
(1, 'Policies'),
(2, 'Billing'),
(3, 'Claims'),
(4, 'Reports');

insert into featurerequest
(requestID, title, description, client, priority, targetDate, productArea, rowStatus, createTimestamp, lastUpdateTimestamp)
values
(100, 'Feature A improvement', 'Make feature A better than feature B but not better than feature C.', 2, 3, '2019-05-01', 1, 'A',
CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(101, 'Add edit function for hazmat briefing', 'Completed briefings should be editable from the view screen.', 1, 1, '2019-05-31', 1, 'A',
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);