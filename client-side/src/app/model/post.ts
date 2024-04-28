export interface Post {
  id: string;
  title: string;
  description: string;
  username: string;
  createdAt: Date;
  upVote: number;
  hasVoted: boolean;
}
