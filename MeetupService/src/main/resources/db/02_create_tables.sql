SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON

CREATE TABLE [core].[Users](
    [id] [int]  IDENTITY(1,1) NOT NULL,
    [object_id] [nvarchar](50) NULL,
    [email] [nvarchar](100) NOT NULL,
    [gender] [char](1) NOT NULL,
    CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [core].[Users] ADD  CONSTRAINT [DF_Users_gender]  DEFAULT (N'M') FOR [gender]

ALTER TABLE [core].[Users]  WITH CHECK ADD  CONSTRAINT [CK_Users] CHECK  (([gender]='U' OR [gender]='F' OR [gender]='M'))

ALTER TABLE [core].[Users] CHECK CONSTRAINT [CK_Users]
