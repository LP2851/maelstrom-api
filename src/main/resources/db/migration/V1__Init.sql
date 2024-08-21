CREATE TABLE "users" (
    "id" uuid PRIMARY KEY,
    "username" varchar(255) UNIQUE NOT NULL,
    "email" varchar(255) UNIQUE NOT NULL,
    "first_name" varchar(255) NOT NULL,
    "last_name" varchar(255) NOT NULL,
    "phone" varchar(16) NOT NULL,
    "follows" int NOT NULL DEFAULT 0,
    "created_at" timestamp NOT NULL DEFAULT (NOW()),
    "updated_at" timestamp NOT NULL
);

CREATE TABLE "posts" (
    "id" uuid PRIMARY KEY,
    "user_id" uuid NOT NULL,
    "content" text NOT NULL,
    "image" text,
    "likes" int NOT NULL DEFAULT 0,
    "created_at" timestamp NOT NULL DEFAULT (NOW()),
    "updated_at" timestamp NOT NULL
);

CREATE TABLE "comments" (
    "id" uuid PRIMARY KEY,
    "post_id" uuid NOT NULL,
    "user_id" uuid NOT NULL,
    "content" text NOT NULL,
    "created_at" timestamp NOT NULL DEFAULT (NOW()),
    "updated_at" timestamp NOT NULL
);

CREATE TABLE "likes" (
    "id" uuid PRIMARY KEY,
    "post_id" uuid NOT NULL,
    "user_id" uuid NOT NULL,
    "created_at" timestamp NOT NULL DEFAULT (NOW())
);

CREATE TABLE "follows" (
      "id" uuid PRIMARY KEY,
      "user_id" uuid NOT NULL,
      "followed_user_id" uuid NOT NULL,
      "created_at" timestamp NOT NULL DEFAULT (NOW())
);

CREATE TABLE "messages" (
    "id" uuid PRIMARY KEY,
    "sender_id" uuid NOT NULL,
    "receiver_id" uuid NOT NULL,
    "content" text NOT NULL,
    "read_at" timestamp,
    "created_at" timestamp NOT NULL DEFAULT (NOW())
);

ALTER TABLE "posts" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("post_id") REFERENCES "posts" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("post_id") REFERENCES "posts" ("id");

ALTER TABLE "likes" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "follows" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "follows" ADD FOREIGN KEY ("followed_user_id") REFERENCES "users" ("id");

ALTER TABLE "messages" ADD FOREIGN KEY ("sender_id") REFERENCES "users" ("id");

ALTER TABLE "messages" ADD FOREIGN KEY ("receiver_id") REFERENCES "users" ("id");