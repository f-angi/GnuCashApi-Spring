INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('9997207548224085be86edf3143533ef','Root Account','ROOT','301eba2ead67436ab5c4227673ec9737',100,0,NULL,'','',0,0),
	 ('53b7db6552d244b5a13acb9f817e4833','Assets','ASSET','301eba2ead67436ab5c4227673ec9737',100,0,'9997207548224085be86edf3143533ef','','Assets',0,1),
	 ('4fe0635566784ff6987090895322153b','Current Assets','ASSET','301eba2ead67436ab5c4227673ec9737',100,0,'53b7db6552d244b5a13acb9f817e4833','','Current Assets',0,1),
	 ('6d924b233bae433da8a7bb598ddbc109','Checking Account','BANK','301eba2ead67436ab5c4227673ec9737',100,0,'4fe0635566784ff6987090895322153b','','Checking Account',0,0),
	 ('8332b89790634aea8b0ef0aa8b48b704','Savings Account','BANK','301eba2ead67436ab5c4227673ec9737',100,0,'4fe0635566784ff6987090895322153b','','Savings Account',0,0),
	 ('6c41a58ebac04bf3a48416118999b73e','Cash in Wallet','CASH','301eba2ead67436ab5c4227673ec9737',100,0,'4fe0635566784ff6987090895322153b','','Cash in Wallet',0,0),
	 ('4a0ec1d05a9942fda718ad9f81e605d3','Liabilities','LIABILITY','301eba2ead67436ab5c4227673ec9737',100,0,'9997207548224085be86edf3143533ef','','Liabilities',0,1),
	 ('8bcd5be47c0d42d18db84f307428ce06','Credit Card','CREDIT','301eba2ead67436ab5c4227673ec9737',100,0,'4a0ec1d05a9942fda718ad9f81e605d3','','Credit Card',0,0),
	 ('d4b65f51122e46798c82864850b4081d','Income','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'9997207548224085be86edf3143533ef','','Income',0,1),
	 ('2294ab52b8494e90bdfedd32e5ad1c04','Bonus','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'d4b65f51122e46798c82864850b4081d','','Bonus',0,0);
INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('9210c60be0da468998fe1bd70ab8fc7b','Gifts Received','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'d4b65f51122e46798c82864850b4081d','','Gifts Received',0,0),
	 ('90ca90a65f0541fc84f1655af38ac572','Interest Income','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'d4b65f51122e46798c82864850b4081d','','Interest Income',0,0),
	 ('a33f674c1748442b804b7791ffb51441','Checking Interest','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'90ca90a65f0541fc84f1655af38ac572','','Checking Interest',0,0),
	 ('77f577741f7b4f799a7d8ecd3fb86fac','Other Interest','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'90ca90a65f0541fc84f1655af38ac572','','Other Interest',0,0),
	 ('cfd35e6c856f478287e96cfde41b9da7','Savings Interest','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'90ca90a65f0541fc84f1655af38ac572','','Savings Interest',0,0),
	 ('7ceee19f93014e8cb9f96cf6720daff8','Other Income','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'d4b65f51122e46798c82864850b4081d','','Other Income',0,0),
	 ('653f596b292b42b08e5e5e7bc3961869','Salary','INCOME','301eba2ead67436ab5c4227673ec9737',100,0,'d4b65f51122e46798c82864850b4081d','','Salary',0,0),
	 ('474342f3128b4b19b0a30b0f30cc0c04','Expenses','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'9997207548224085be86edf3143533ef','','Expenses',0,1),
	 ('4820ced9c7194abb81220b504f64f2ba','Adjustment','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Adjustment',0,0),
	 ('45bb5dd27a2a4a1e8e6169e8fa5565cd','Auto','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Auto',0,0);
INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('e1fc9d1c612e42a98c589732b3e59740','Fees','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'45bb5dd27a2a4a1e8e6169e8fa5565cd','','Fees',0,0),
	 ('45fb62e1582c45c09417161a283e2756','Gas','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'45bb5dd27a2a4a1e8e6169e8fa5565cd','','Gas',0,0),
	 ('e171936eceab4258a606ed3cbfeb1005','Parking','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'45bb5dd27a2a4a1e8e6169e8fa5565cd','','Parking',0,0),
	 ('5d521a11e2194539b617a84937a0ce4b','Repair and Maintenance','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'45bb5dd27a2a4a1e8e6169e8fa5565cd','','Repair and Maintenance',0,0),
	 ('b4019160630744708a8317c1af6d6506','Bank Service Charge','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Bank Service Charge',0,0),
	 ('0a76cfd0b40d4a32ace77ed09dd25de4','Books','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Books',0,0),
	 ('a55b5562645446b188cf60b5c3303730','Cable','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Cable',0,0),
	 ('f62905ce8bc2413cb2140447eda9e767','Charity','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Charity',0,0),
	 ('23969ec4bdb04daf8d59c8cfa86efdbf','Clothes','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Clothes',0,0),
	 ('d29c203fd63e48128ec40d70bb87db62','Computer','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Computer',0,0);
INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('f0802f4c740546d1b06ee36d2134c94c','Dining','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Dining',0,0),
	 ('645ce49152cd49cbad5c884df1be8126','Education','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Education',0,0),
	 ('e9c50aee353344afaf38b05cd02bd083','Entertainment','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Entertainment',0,0),
	 ('d9006c9339bc4729a1216a33636945d2','Music/Movies','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'e9c50aee353344afaf38b05cd02bd083','','Music/Movies',0,0),
	 ('646651de3c134b15aaa00dc376a3da83','Recreation','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'e9c50aee353344afaf38b05cd02bd083','','Recreation',0,0),
	 ('5077f946d911446eaec493db575f154c','Travel','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'e9c50aee353344afaf38b05cd02bd083','','Travel',0,0),
	 ('52f2e734c1b24ec69f2b126b5a3b2bdf','Gifts','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Gifts',0,0),
	 ('caf2e35593084ad3892bc7a029cc60b1','Groceries','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Groceries',0,0),
	 ('76ba2e1c3d16414b84aff64fa8e0a554','Hobbies','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Hobbies',0,0),
	 ('b5d5c992bfa04a70bc4d111681c695a1','Insurance','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Insurance',0,0);
INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('b0256d4e3c8c427298d103d52ac9d18e','Auto Insurance','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'b5d5c992bfa04a70bc4d111681c695a1','','Auto Insurance',0,0),
	 ('f08d56ed79eb4440aedd997fade3f7c7','Health Insurance','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'b5d5c992bfa04a70bc4d111681c695a1','','Health Insurance',0,0),
	 ('9af6b24fde4847ee9366f9e3bb6843b1','Life Insurance','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'b5d5c992bfa04a70bc4d111681c695a1','','Life Insurance',0,0),
	 ('23c4ca8a7b0b4668893205c1951ec18e','Laundry/Dry Cleaning','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Laundry/Dry Cleaning',0,0),
	 ('cdcf696c1e49450db5419834417b6869','Medical Expenses','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Medical Expenses',0,0),
	 ('9d58415ef4b7493f8b3d844b408ea856','Miscellaneous','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Miscellaneous',0,0),
	 ('d1df83b787764798a68a9ee1f685ef4e','Online Services','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Online Services',0,0),
	 ('9e06d3c7ed13496ba5f3ad3851c4ce93','Phone','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Phone',0,0),
	 ('70b6178b609e4531b0edd7685b0734bb','Public Transportation','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Public Transportation',0,0),
	 ('6c42395e635440b480b99642c70010f5','Subscriptions','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Subscriptions',0,0);
INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('bcbbd588a0e34ae484766345b299f961','Supplies','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Supplies',0,0),
	 ('1f58248823f94acabe5b6d5e9d536178','Taxes','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Taxes',0,0),
	 ('001dbe8ac9fb4628b9ff40f2887e15f9','Federal','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'1f58248823f94acabe5b6d5e9d536178','','Federal',0,0),
	 ('c02b7857956749e894d0195b1e534212','Medicare','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'1f58248823f94acabe5b6d5e9d536178','','Medicare',0,0),
	 ('8451e8c70c4d473bac640aa68dca02c0','Other Tax','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'1f58248823f94acabe5b6d5e9d536178','','Other Tax',0,0),
	 ('90d1b6214c844a30b0fb39f96d64e6e8','Social Security','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'1f58248823f94acabe5b6d5e9d536178','','Social Security',0,0),
	 ('fa94efd71b6541398b2c46de9f6c0156','State/Province','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'1f58248823f94acabe5b6d5e9d536178','','State/Province',0,0),
	 ('4093e29a3d8b42188d15764175f0f661','Utilities','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'474342f3128b4b19b0a30b0f30cc0c04','','Utilities',0,0),
	 ('d1ed525fd983414a83cdc0021424930d','Electric','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'4093e29a3d8b42188d15764175f0f661','','Electric',0,0),
	 ('863e54042b0b423b9aeb607a86370efc','Garbage collection','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'4093e29a3d8b42188d15764175f0f661','','Garbage collection',0,0);
INSERT INTO public.accounts (guid,name,account_type,commodity_guid,commodity_scu,non_std_scu,parent_guid,code,description,hidden,placeholder) VALUES
	 ('a83fee8ceca54373bbbf5463dc4b6bc4','Gas','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'4093e29a3d8b42188d15764175f0f661','','Gas',0,0),
	 ('00139d34340e440083b283d70b3f0fae','Water','EXPENSE','301eba2ead67436ab5c4227673ec9737',100,0,'4093e29a3d8b42188d15764175f0f661','','Water',0,0),
	 ('3109e83d1ffe46de987af8e925df99ba','Equity','EQUITY','301eba2ead67436ab5c4227673ec9737',100,0,'9997207548224085be86edf3143533ef','','Equity',0,1),
	 ('5153d82779cb4a4687c9d98abf24f077','Opening Balances','EQUITY','301eba2ead67436ab5c4227673ec9737',100,0,'3109e83d1ffe46de987af8e925df99ba','','Opening Balances',0,0),
	 ('019b2bf67b7c490b86fe3b948e56d6fa','Template Root','ROOT',NULL,0,0,NULL,'','',0,0);
INSERT INTO public.transactions (guid,currency_guid,num,post_date,enter_date,description) VALUES
	 ('da4dbc25f09d40abb447ee1f42db568f','301eba2ead67436ab5c4227673ec9737','','2022-09-01 10:59:00','2022-09-01 15:20:53','salary'),
	 ('eb2a6f9d712242ba9f5d0bd589c6d543','301eba2ead67436ab5c4227673ec9737','','2022-09-01 10:59:00','2022-09-01 15:21:12','withdrawal'),
	 ('32a565f24a3d4d2da4027f4d5d4d829b','301eba2ead67436ab5c4227673ec9737','','2022-09-01 10:59:00','2022-09-01 15:22:08','dinner'),
	 ('32a565f24a3d4d2da4027f4d5d4d829c','301eba2ead67436ab5c4227673ec9737','','2023-01-03 11:58:00','2023-01-03 15:22:08','lunch'),
	 ('32a565f24a3d4d2da4027f4d5d4d829d','301eba2ead67436ab5c4227673ec9737','','2022-09-01 10:59:00','2022-10-13 15:22:08','breakfast');
INSERT INTO public.splits (guid,tx_guid,account_guid,memo,"action",reconcile_state,reconcile_date,value_num,value_denom,quantity_num,quantity_denom,lot_guid) VALUES
	 ('ef8cae4d18be4a1b86436274ec5d7c02','da4dbc25f09d40abb447ee1f42db568f','653f596b292b42b08e5e5e7bc3961869','','','n','1970-01-01 00:00:00',-100000,100,-100000,100,NULL), -- account: Salary
	 ('99b8c3c797254573b1c5be71e443b3c1','da4dbc25f09d40abb447ee1f42db568f','8332b89790634aea8b0ef0aa8b48b704','','','n','1970-01-01 00:00:00',100000,100,100000,100,NULL), -- account: Savings Account
	 ('e7f166000b9b4b93a5b5c39e63010c87','eb2a6f9d712242ba9f5d0bd589c6d543','8332b89790634aea8b0ef0aa8b48b704','','','n','1970-01-01 00:00:00',-20000,100,-20000,100,NULL), -- account: Savings Account
	 ('331bac3c85fc4a808f9b853d9fcb42fb','eb2a6f9d712242ba9f5d0bd589c6d543','6c41a58ebac04bf3a48416118999b73e','','','n','1970-01-01 00:00:00',20000,100,20000,100,NULL), -- account: Cash in Wallet
	 ('e0def90a05454325b00378109a0e32e9','32a565f24a3d4d2da4027f4d5d4d829b','646651de3c134b15aaa00dc376a3da83','','','n','1970-01-01 00:00:00',6000,100,6000,100,NULL), -- account: Recreation
	 ('dc075451cc3f4cf39c440a1c59922369','32a565f24a3d4d2da4027f4d5d4d829b','6c41a58ebac04bf3a48416118999b73e','','','n','1970-01-01 00:00:00',-6000,100,-6000,100,NULL), -- account: Cash in Wallet
	 ('e0def90a05454325b00378109a0e32e8','32a565f24a3d4d2da4027f4d5d4d829c','646651de3c134b15aaa00dc376a3da83','','','n','1970-01-01 00:00:00',1400,100,1400,100,NULL), -- account: Recreation
	 ('dc075451cc3f4cf39c440a1c59922368','32a565f24a3d4d2da4027f4d5d4d829c','6c41a58ebac04bf3a48416118999b73e','','','n','1970-01-01 00:00:00',-1400,100,-1400,100,NULL), -- account: Cash in Wallet	 ('e0def90a05454325b00378109a0e32e8','32a565f24a3d4d2da4027f4d5d4d829c','646651de3c134b15aaa00dc376a3da83','','','n','1970-01-01 00:00:00',1400,100,14000,100,NULL), -- account: Recreation
	 ('e0def90a05454325b00378109a0e52e8','32a565f24a3d4d2da4027f4d5d4d829d','646651de3c134b15aaa00dc376a3da83','','','n','1970-01-01 00:00:00',400,100,400,100,NULL), -- account: Recreation
	 ('dc075451cc3f4cf39c440a1c59912368','32a565f24a3d4d2da4027f4d5d4d829d','6c41a58ebac04bf3a48416118999b73e','','','n','1970-01-01 00:00:00',-400,100,-400,100,NULL); -- account: Cash in Wallet