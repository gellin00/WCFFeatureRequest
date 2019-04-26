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
(requestID, title, description, clientid, priority, targetDate, areaid, rowStatus, createTimestamp)
values
(1, 'Client A item 1', 'Client A item 1', 1, 1, '2019-05-01', 1, 'A', CURRENT_TIMESTAMP),
(2, 'Client A item 2', 'Client A item 2', 1, 2, '2019-05-02', 1, 'A', CURRENT_TIMESTAMP),
(3, 'Client A item 3', 'Client A item 3', 1, 3, '2019-05-03', 2, 'A', CURRENT_TIMESTAMP),
(4, 'Client A item 4', 'Client A item 4', 1, 4, '2019-05-04', 2, 'A', CURRENT_TIMESTAMP),
(5, 'Client A item 5', 'Client A item 5', 1, 5, '2019-05-05', 3, 'A', CURRENT_TIMESTAMP),
(6, 'Client A item 6', 'Client A item 6', 1, 6, '2019-05-06', 3, 'A', CURRENT_TIMESTAMP),
(7, 'Client A item 7', 'Client A item 7', 1, 7, '2019-05-07', 4, 'A', CURRENT_TIMESTAMP),
(8, 'Client A item 8', 'Client A item 8', 1, 8, '2019-05-08', 4, 'A', CURRENT_TIMESTAMP),
(9, 'Client A item 9', 'Client A item 9', 1, 9, '2019-05-09', 4, 'A', CURRENT_TIMESTAMP),
(10, 'Client B item 1', 'Client B item 1', 2, 1, '2019-05-03', 1, 'A', CURRENT_TIMESTAMP),
(11, 'Client B item 2', 'Client B item 2', 2, 2, '2019-05-03', 1, 'A', CURRENT_TIMESTAMP),
(12, 'Client B item 3', 'Client B item 3', 2, 3, '2019-05-03', 2, 'A', CURRENT_TIMESTAMP),
(13, 'Client B item 4', 'Client B item 4', 2, 4, '2019-05-03', 2, 'A', CURRENT_TIMESTAMP),
(14, 'Client B item 5', 'Client B item 5', 2, 5, '2019-05-03', 3, 'A', CURRENT_TIMESTAMP),
(15, 'Client C item 1', 'Client C item 1', 3, 1, '2019-05-05', 1, 'A', CURRENT_TIMESTAMP),
(16, 'Client C item 2', 'Client C item 2', 3, 2, '2019-05-05', 2, 'A', CURRENT_TIMESTAMP),
(17, 'Client C item 3', 'Client C item 3', 3, 3, '2019-05-05', 3, 'A', CURRENT_TIMESTAMP),
(18, 'Deleted Item 1', 'Deleted Item 1', 1, 1, '2019-05-10', 1, 'I', CURRENT_TIMESTAMP),
(19, 'Deleted Item 2', 'Deleted Item 2', 2, 1, '2019-05-10', 1, 'I', CURRENT_TIMESTAMP),
(20, 'Deleted Item 3', 'Deleted Item 3', 3, 1, '2019-05-10', 1, 'I', CURRENT_TIMESTAMP);