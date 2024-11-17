SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON

CREATE TABLE [core].[EventFees](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [description] [nvarchar](50) NOT NULL,
    [active] [tinyint] NOT NULL DEFAULT 1,
    CONSTRAINT [PK_EventFees] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

CREATE TABLE [core].[EventFeePrices](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [event_fee_id] [int] NOT NULL,
    [price_all_gender] [money] NULL,
    [price_male] [money] NULL,
    [price_female] [money] NULL,
    CONSTRAINT [PK_EventFeePrices] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [core].[EventFeePrices]  WITH CHECK ADD  CONSTRAINT [FK_EventFeePrices_EventFees] FOREIGN KEY([event_fee_id])
    REFERENCES [core].[EventFees] ([id])

ALTER TABLE [core].[EventFeePrices] CHECK CONSTRAINT [FK_EventFeePrices_EventFees]

CREATE INDEX IX_EventFeePrices_EventFeeId ON [core].[EventFeePrices] (event_fee_id);
