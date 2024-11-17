insert into [core].[EventFees] (description, active) values ('Free',1);
insert into [core].[EventFees] (description, active) values ('Standard_2024',1);
insert into [core].[EventFees] (description, active) values ('Standard_2025',1);
insert into [core].[EventFees] (description, active) values ('Promotion_2024',1);
insert into [core].[EventFees] (description, active) values ('Promotion_2025',1);

insert into [core].[EventFeePrices] (event_fee_id, price_all_gender, price_male, price_female)
values ((select id from [core].[EventFees] where description = 'Free'),0,0,0);
insert into [core].[EventFeePrices] (event_fee_id, price_all_gender, price_male, price_female)
values ((select id from [core].[EventFees] where description = 'Standard_2024'),10,10,10);
insert into [core].[EventFeePrices] (event_fee_id, price_all_gender, price_male, price_female)
values ((select id from [core].[EventFees] where description = 'Standard_2025'),10,10,10);
insert into [core].[EventFeePrices] (event_fee_id, price_all_gender, price_male, price_female)
values ((select id from [core].[EventFees] where description = 'Promotion_2024'),0,10,5);
insert into [core].[EventFeePrices] (event_fee_id, price_all_gender, price_male, price_female)
values ((select id from [core].[EventFees] where description = 'Promotion_2025'),0,10,5);