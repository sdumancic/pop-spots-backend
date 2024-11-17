SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [core].[EventTypes](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [name] [nvarchar](20) NOT NULL,
    [description] [nvarchar](200) NULL,
    [active] [tinyint] NOT NULL DEFAULT 1,
    CONSTRAINT [PK_EventTypes] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

CREATE TABLE [core].[Events](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [name] [nvarchar](30) NOT NULL,
    [description] [nvarchar](200) NULL,
    [type_id] [int] NOT NULL,
    [start_ts] [datetime] NOT NULL,
    [end_ts] [datetime] NULL,
    [max_no_participants] [smallint] NULL,
    [entry_fee_id] [int] NULL,
    [location] [geometry] NULL,
    [owner_id] [int] NULL,
    [is_closed_event] [tinyint] NULL,
    [status_id] [smallint] NOT NULL DEFAULT 1,
    CONSTRAINT [PK_Events] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

ALTER TABLE [core].[Events]  WITH CHECK ADD  CONSTRAINT [FK_Events_EventFeePrices] FOREIGN KEY([entry_fee_id])
    REFERENCES [core].[EventFeePrices] ([id])

ALTER TABLE [core].[Events] CHECK CONSTRAINT [FK_Events_EventFeePrices]

ALTER TABLE [core].[Events]  WITH CHECK ADD  CONSTRAINT [FK_Events_EventTypes] FOREIGN KEY([type_id])
    REFERENCES [core].[EventTypes] ([id])

ALTER TABLE [core].[Events] CHECK CONSTRAINT [FK_Events_EventTypes]

ALTER TABLE [core].[Events]  WITH CHECK ADD  CONSTRAINT [FK_Events_Users] FOREIGN KEY([owner_id])
    REFERENCES [core].[Users] ([id])

ALTER TABLE [core].[Events] CHECK CONSTRAINT [FK_Events_Users]

CREATE TABLE [core].[InvitedParticipants](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [event_id] [int] NOT NULL,
    [user_id] [int] NOT NULL,
    [invited_by_user_id] [int] NULL,
    [sent_ts] [datetime] NULL,
    [response_id] [smallint] NULL,
    [response_ts] [datetime] NULL,
    [response_message] [nvarchar](50) NULL,
    CONSTRAINT [PK_InvitedParticipants] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [core].[InvitedParticipants]  WITH CHECK ADD  CONSTRAINT [FK_InvitedParticipants_Events] FOREIGN KEY([event_id])
    REFERENCES [core].[Events] ([id])

ALTER TABLE [core].[InvitedParticipants] CHECK CONSTRAINT [FK_InvitedParticipants_Events]

ALTER TABLE [core].[InvitedParticipants]  WITH CHECK ADD  CONSTRAINT [FK_InvitedParticipants_Users1] FOREIGN KEY([user_id])
    REFERENCES [core].[Users] ([id])

ALTER TABLE [core].[InvitedParticipants] CHECK CONSTRAINT [FK_InvitedParticipants_Users1]

ALTER TABLE [core].[InvitedParticipants]  WITH CHECK ADD  CONSTRAINT [FK_InvitedParticipants_Users2] FOREIGN KEY([invited_by_user_id])
    REFERENCES [core].[Users] ([id])

ALTER TABLE [core].[InvitedParticipants] CHECK CONSTRAINT [FK_InvitedParticipants_Users2]

CREATE INDEX IX_InvitedParticipants_EventId ON [core].[InvitedParticipants] (event_id);
CREATE INDEX IX_InvitedParticipants_UserId ON [core].[InvitedParticipants] (user_id);
CREATE INDEX IX_InvitedParticipants_InvitedByUserId ON [core].[InvitedParticipants] (invited_by_user_id);