insert into [core].[Events] (name, description, type_id, start_ts, end_ts, max_no_participants, entry_fee_id, location,
                             owner_id, is_closed_event, status_id)
values ('Test event 01',
    'Test event 01',
    (Select id from [core].[EventTypes] where name = 'Others'),
    CAST('2024-11-16 20:00:00' as datetime),
    CAST('2024-11-16 23:59:59' as datetime),
    10,
    null,
    GEOMETRY::STPointFromText('POINT(16.4572959 46.3910801)', 4326),
    (Select id from [core].[Users] where email = 'email1@test.com'),
    1,
    1
    );

insert into [core].[Events] (name, description, type_id, start_ts, end_ts, max_no_participants, entry_fee_id, location,
                             owner_id, is_closed_event, status_id)
values ('Test event 02',
    'Test event 02',
    (Select id from [core].[EventTypes] where name = 'Movie night'),
    CAST('2024-11-17 20:00:00' as datetime),
    CAST('2024-11-17 23:59:59' as datetime),
    10,
    null,
    GEOMETRY::STPointFromText('POINT(16.4572959 46.3910801)', 4326),
    (Select id from [core].[Users] where email = 'email1@test.com'),
    1,
    1
    )