SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [core].[RedisUserCheckInStatus](
    [user_id] [int] NOT NULL,
    [event_id] [int] NOT NULL,
    [ts] [datetime],
    [status] [nvarchar](20) NOT NULL
    CONSTRAINT [PK_RedisUserCheckInStatus] PRIMARY KEY CLUSTERED
(
[user_id] ASC, [event_id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

CREATE TABLE [core].[RedisUserCheckInStatusHistory](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [user_id] [int] NOT NULL,
    [event_id] [int] NOT NULL,
    [ts] [datetime],
    [status] [nvarchar](20) NOT NULL
    CONSTRAINT [PK_RedisUserCheckInStatusHistory] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]


CREATE INDEX IX_RedisUserCheckInStatusHistory_EventId ON [core].[RedisUserCheckInStatusHistory] (event_id);
CREATE INDEX IX_RedisUserCheckInStatusHistory_UserId ON [core].[RedisUserCheckInStatusHistory] (user_id);